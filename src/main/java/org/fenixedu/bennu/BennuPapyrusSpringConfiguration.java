package org.fenixedu.bennu;

import org.fenixedu.bennu.spring.BennuSpringModule;
import org.fenixedu.commons.configuration.ConfigurationManager;
import org.fenixedu.commons.configuration.ConfigurationProperty;
import org.springframework.context.annotation.Bean;
import pt.ist.papyrus.PapyrusClient;
import pt.ist.papyrus.PapyrusSettings;

@BennuSpringModule(basePackages = "org.fenixedu.bennu.papyrus", bundles = "BennuPapyrusResources")
public class BennuPapyrusSpringConfiguration {

    @Bean
    public PapyrusClient papyrusClient() {
        return new PapyrusClient();
    }

    @Bean
    public PapyrusSettings defaultSettings() {
        return PapyrusSettings.newBuilder().landscape(false).format("A4").pdfA(true).build();
    }

    @ConfigurationManager(description = "IT services Papyrus team")
    public interface ConfigurationProperties {
        @ConfigurationProperty(key = "papyrus.4e4ab43c-9da3-444f-9317-2b6cce7a5cb2.url", defaultValue = "https://master.papyrus-tecnico.al.vps.tecnico.ulisboa.pt")
        String getPapyrusUrl();

        @ConfigurationProperty(key = "papyrus.4e4ab43c-9da3-444f-9317-2b6cce7a5cb2.token", defaultValue = "SecretToken")
        String getPapyrusToken();
    }
}
