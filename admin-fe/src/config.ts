export interface ApplicationConfig {
  API_ENDPOINT: string;
}

const devConfig: ApplicationConfig = {
  API_ENDPOINT: "http://localhost:8082",
};

const prodConfig: ApplicationConfig = {
  API_ENDPOINT: "http://localhost:8082",
};

export default {
  development: devConfig,
  production: prodConfig,
};
