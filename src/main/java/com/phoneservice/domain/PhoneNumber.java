package com.phoneservice.domain;

import com.phoneservice.service.validation.PhoneNumberRegexValidationService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DiscriminatorFormula;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name= "customer")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorFormula("Case " +
        "WHEN SUBSTR(phone, 2, 3)  = '237' THEN 'CameroonPhoneNumber' " +
        "WHEN SUBSTR(phone, 2, 3)  = '251' THEN 'EthiopiaPhoneNumber' " +
        "WHEN SUBSTR(phone, 2, 3)  = '212' THEN 'MoroccoPhoneNumber' " +
        "WHEN SUBSTR(phone, 2, 3)  = '258' THEN 'MozambiquePhoneNumber' " +
        "WHEN SUBSTR(phone, 2, 3)  = '256' THEN 'UgandaPhoneNumber' " +
        "ELSE null " +
        "END " )
@DiscriminatorValue("null")
public class PhoneNumber{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String customerName;

    @Column(name = "phone")
    private String number;

    @Transient
    private boolean isValid;

    @Transient
    private Country country;

    @PostLoad
    private void basePostLoad() {
        this.setCountry(Country.UNKNOWN);
    }

    public void acceptRegexValidationService(PhoneNumberRegexValidationService service){
       this.setValid(false);
    }
}
