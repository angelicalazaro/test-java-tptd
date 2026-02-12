package com.ipi.jva350.model; // même package que la classe testée

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SalarieAideADomicileTest {

    @Test
    void naPasDroitQuandJoursInferieurA10() {
        // GIVEN
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        salarie.setJoursTravaillesAnneeNMoins1(9);
        // WHEN
        boolean resultat = salarie.aLegalementDroitADesCongesPayes();
        // THEN
        Assertions.assertFalse(resultat);
    }
    @Test
    void naPasDroitQuandJoursEgalA10() {
        // GIVEN
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        salarie.setJoursTravaillesAnneeNMoins1(10);
        // WHEN
        boolean resultat = salarie.aLegalementDroitADesCongesPayes();
        // THEN
        Assertions.assertTrue(resultat);
    }
    @Test
    void aDroitQuandJoursSuperieurA10() {
        // GIVEN
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        salarie.setJoursTravaillesAnneeNMoins1(11);
        // WHEN
        boolean resultat = salarie.aLegalementDroitADesCongesPayes();
        // THEN
        Assertions.assertTrue(resultat);
    }
}
