package com.ipi.jva350.model; // même package que la classe testée

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.LinkedHashSet;

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
    @ParameterizedTest(name = "plage de congés {0}-{1} n'a pas le bon nombre de jours : {2}")
    @CsvSource({
            "'2026-08-01', '2026-08-21', 17",
            "'2025-12-22', '2026-01-05', 11",
            "'2025-11-11', '2025-11-11', 0",
    })
    public void testCalculeJoursDeCongeDecomptesPourPlage(String dateDebutString, String dateFinString, int nbJoursDeConges) {
        // Given,
        SalarieAideADomicile monSalarie = new SalarieAideADomicile();
        LocalDate dateDebut = LocalDate.parse(dateDebutString);
        LocalDate dateFin = LocalDate.parse(dateFinString);
        // When,
        LinkedHashSet<LocalDate> res = monSalarie.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin);
        // Then
        Assertions.assertEquals(nbJoursDeConges, res.size());
    }
}
