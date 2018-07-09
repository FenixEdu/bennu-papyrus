package org.fenixedu.bennu;

import org.fenixedu.bennu.spring.BennuSpringModule;
import org.springframework.context.annotation.Bean;
import pt.ist.papyrus.PapyrusClient;
import pt.ist.papyrus.PapyrusConfiguration;
import pt.ist.papyrus.PapyrusSettings;

@BennuSpringModule(basePackages = "org.fenixedu.bennu.papyrus", bundles = "BennuPapyrusResources")
public class BennuPapyrusSpringConfiguration {

    @Bean
    public PapyrusClient papyrusClient() {
        return new PapyrusClient(PapyrusConfiguration.getConfiguration().papyrusUrl(), PapyrusConfiguration.getConfiguration().papyrusToken());
    }

    @Bean
    public PapyrusSettings defaultSettings() {
        return PapyrusSettings.newBuilder().landscape(true).size("A4").pdfA(true).build();
    }
}
