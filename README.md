### adapter-bank-spring-boot-starter

**Adapter-bank-spring-boot-starter** - это подключаемый Spring Boot модуль для стандартных компонентов proxy-адаптеров.

```yaml
adapter-bank-spring-boot-starter:
  object-mapper:
    enabled: true
  error-mapping:
    enabled: true
  rest-template:
    enabled: true
  request-logging-aspect:
    enabled: true
  network:
    enabled: true
  logging-interceptor:
    enabled: false
  hellgate-client:
    enabled: true
  cds-storage-client:
    enabled: true
  cds-id-storage-client:
    enabled: true
  bender-client:
    enabled: true
  adapter:
    enabled: true
  timer:
    enabled: true
  serde:
    enabled: true
  processor:
    enabled: true
  ctxToEntryModelConverter:
    enabled: true
  entryModelToBaseRequestModelConverter:
    enabled: true
  exitModelToProxyResultConverter:
    enabled: true
  exitModelToRecTokenProxyResultConverter:
    enabled: true
  exitStateModelToTemporaryContextConverter:
    enabled: true
  exponentialBackOffPollingService:
    enabled: true
  intentResultFactory:
    enabled: true
  paymentCallbackHandler:
    enabled: true
  paymentServerFlowHandler:
    enabled: true
  recCtxToEntryModelConverter:
    enabled: true
  recurrentIntentResultFactory:
    enabled: true
  recurrentResultIntentResolver:
    enabled: true
  recurrentTokenCallbackHandler:
    enabled: true
  resultIntentResolver:
    enabled: true
  serverHandlerLogDecorator:
    enabled: true
  stepResolver:
    enabled: true
  temporaryContextService:
    enabled: true
  threeDsAdapterService:
    enabled: true
  tokenServerFlowHandler:
    enabled: true

adapter:
  url: http://127.0.0.1
  callbackUrl: http://127.0.0.1:8080
  pathCallbackUrl: /${server.rest.endpoint}/term_url
  pathRecurrentCallbackUrl: /${server.rest.endpoint}/rec_term_url
  defaultTermUrl: https://checkout.empayre.com/v1/finish-interaction.html
  tagPrefix: adapter-

bender:
  client:
    url: http://127.0.0.1:8022/v1/bender
    networkTimeout: 5000
    namespace: namespace

cds:
  client:
    identity-document-storage:
      url: http://127.0.0.1:8022/v1/identity_document_storage
      networkTimeout: 5000
    storage:
      url: http://127.0.0.1:8022/v1/storage
      networkTimeout: 5000

hellgate:
  client:
    url: http://127.0.0.1:8022/v1/proxyhost/provider
    networkTimeout: 30000

time:
  config:
    maxTimePollingMin: 60
    pollingDelayMs: 1000
    redirectTimeoutMin: 15
    exponential: 2
    defaultInitialExponential: 2
    maxTimeBackOff: 600
    maxTimeCoefficient: 2

rest-template:
  requestTimeout: 60000
  poolTimeout: 10000
  connectionTimeout: 10000
  maxTotalPooling: 200
  defaultMaxPerRoute: 200
  networkTimeout: 60000
  connectTimeout: 10000

error-mapping:
  file: classpath:fixture/errors.json
  patternReason: "'%s' - '%s'" # 'code' - 'description'
```