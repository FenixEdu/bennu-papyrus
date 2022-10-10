package org.fenixedu.bennu;

import org.fenixedu.bennu.spring.BennuSpringModule;
import org.springframework.context.annotation.Bean;
import pt.ist.papyrus.PapyrusClient;
import pt.ist.papyrus.PapyrusSettings;

@BennuSpringModule(basePackages = "org.fenixedu.bennu.papyrus", bundles = "BennuPapyrusResources")
public class BennuPapyrusSpringConfiguration {

    @Bean
    public PapyrusClient papyrusClient() {
        return new PapyrusClient(); // The template used here has to belong to the SI team
    }

    @Bean
    public PapyrusSettings defaultSettings() {
        return PapyrusSettings.newBuilder().landscape(false).format("A4").pdfA(true).build();
    }
}
