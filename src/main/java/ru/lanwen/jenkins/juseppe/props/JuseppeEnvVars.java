package ru.lanwen.jenkins.juseppe.props;

import static ru.lanwen.jenkins.juseppe.props.Props.props;

/**
 * @author lanwen (Merkushev Kirill)
 */
public final class JuseppeEnvVars {

    public static final String JUSEPPE_CERT_PATH = "juseppe.certificate";
    public static final String JUSEPPE_PRIVATE_KEY_PATH = "juseppe.private.key";
    public static final String JUSEPPE_PLUGINS_DIR = "juseppe.plugins.dir";
    public static final String JUSEPPE_SAVE_TO_DIR = "juseppe.saveto.dir";
    public static final String JUSEPPE_UC_JSON_NAME = "juseppe.uc.json.name";
    public static final String JUSEPPE_RELEASE_HISTORY_JSON_NAME = "juseppe.release.history.json.name";
    public static final String JUSEPPE_BASE_URI = "juseppe.baseurl";
    public static final String JUSEPPE_UPDATE_CENTER_ID = "juseppe.update.center.id";
    public static final String JUSEPPE_BIND_PORT = "juseppe.jetty.port";

    private JuseppeEnvVars() {
        throw new IllegalAccessError();
    }

    public enum JuseppeEnvEnum {
        JUSEPPE_CERT_PATH(
                JuseppeEnvVars.JUSEPPE_CERT_PATH,
                "path of certificate (must be used in pair with private key prop). Defaults to *uc.crt* "
        ) {
            @Override
            public String resolved() {
                return props().getCert();
            }
        },

        JUSEPPE_PRIVATE_KEY_PATH(
                JuseppeEnvVars.JUSEPPE_PRIVATE_KEY_PATH,
                "path of private key (must be used in pair with cert). Defaults to *uc.key*"
        ) {
            @Override
            public String resolved() {
                return props().getKey();
            }
        },

        JUSEPPE_PLUGINS_DIR(
                JuseppeEnvVars.JUSEPPE_PLUGINS_DIR,
                "where the plugins are. Searches only `*.hpi`. Defaults to *current working dir*"
        ) {
            @Override
            public String resolved() {
                return props().getPlugins();
            }
        },

        JUSEPPE_SAVE_TO_DIR(
                JuseppeEnvVars.JUSEPPE_SAVE_TO_DIR,
                "where to save generated json file. Defaults to *current working dir*"
        ) {
            @Override
            public String resolved() {
                return props().getSaveto();
            }
        },

        JUSEPPE_UC_JSON_NAME(
                JuseppeEnvVars.JUSEPPE_UC_JSON_NAME,
                "name of generated update center json file. Defaults to `update-center.json`"
        ) {
            @Override
            public String resolved() {
                return props().getUcJsonName();
            }
        },

        JUSEPPE_RELEASE_HISTORY_JSON_NAME(
                JuseppeEnvVars.JUSEPPE_RELEASE_HISTORY_JSON_NAME,
                "name of generated release-history json file. Defaults to `release-history.json`"
        ) {
            @Override
            public String resolved() {
                return props().getReleaseHistoryJsonName();
            }
        },

        JUSEPPE_BASE_URI(
                JuseppeEnvVars.JUSEPPE_BASE_URI,
                "url to prepend for plugins download link in json. Defaults to `http://localhost:8080`"
        ) {
            @Override
            public String resolved() {
                return String.valueOf(props().getBaseurl());
            }
        },

        JUSEPPE_UPDATE_CENTER_ID(
                JuseppeEnvVars.JUSEPPE_UPDATE_CENTER_ID,
                "id of the update center. Must be unique inside of jenkins. Defaults to `juseppe`"
        ) {
            @Override
            public String resolved() {
                return props().getUcId();
            }
        },

        JUSEPPE_BIND_PORT(
                JuseppeEnvVars.JUSEPPE_BIND_PORT,
                "port for juseppe file server. Defaults to `8080`"
        ) {
            @Override
            public String resolved() {
                return String.valueOf(props().getPort());
            }
        };

        private String mapping;
        private String description;

        JuseppeEnvEnum(String mapping, String description) {
            this.mapping = mapping;
            this.description = description;
        }

        public String mapping() {
            return mapping;
        }

        public String description() {
            return description;
        }

        public String resolved() {
            throw new AbstractMethodError("Not implemented");
        }
    }
}
