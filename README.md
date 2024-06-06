
# OceanBlue - Gestão Sustentável dos Oceanos

## Visão Geral

**OceanBlue** é uma aplicação desenvolvida para promover uma gestão sustentável dos recursos marinhos, focando na saúde dos oceanos. A solução visa informar e alertar populações costeiras e empresas sobre a qualidade dos mares, utilizando análise de dados para aprimorar o planejamento e a gestão dos recursos marinhos.

## Funcionalidades Principais

1. **Cadastro de Usuários e Assinaturas**:
   - Permite que novos usuários se registrem no sistema.
   - Criação de assinaturas para monitoramento de dados marinhos, onde os usuários podem configurar preferências de notificação e áreas de interesse.

2. **Monitoramento de Poluição**:
   - Coleta de dados ambientais utilizando sensores distribuídos em áreas estratégicas.
   - Monitoramento de níveis de poluição e outros indicadores ambientais críticos para a saúde dos oceanos.

3. **Análise de Dados**:
   - Processamento e análise dos dados coletados pelos sensores.
   - Geração de relatórios detalhados sobre os níveis de poluição e a saúde das áreas monitoradas.
   - Avaliação de métricas ambientais para suportar decisões informadas.

4. **Decisões Automatizadas**:
   - Sugestão de ações baseadas na análise dos dados e nas respostas dos usuários.
   - Propostas de intervenções, como a instalação de novos sensores ou medidas de limpeza para mitigar impactos ambientais.

5. **Manipulação e Exibição de Dados**:
   - Entrada de dados via interface gráfica, classe `Scanner` ou métodos automatizados.
   - Exibição clara e organizada dos valores dos atributos dos objetos criados no sistema.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- `src/com/global/authenticator/`: Contém classes para autenticação de usuários e gerenciamento de assinaturas.
- `src/com/global/data/`: Inclui classes para coleta, armazenamento e análise de dados ambientais.
- `src/com/global/menu/`: Contém as classes que implementam os diferentes menus e a interface gráfica.
- `src/com/global/model/`: Contém os modelos de dados usados no sistema, como usuários, sensores e registros de poluição.

## Requisitos

- **Java 17** ou superior
- **Maven** para gerenciamento de dependências e build
- **Bibliotecas**: `JOptionPane` para interface gráfica, JSON para manipulação de dados

## Instalação

1. Clone o repositório para sua máquina local:
   ```
   git clone https://github.com/MatheusCosta616/OceanBlueJava/tree/main
   ```
2. Navegue até o diretório do projeto:
   ```
   cd OceanBlueJava
   ```
3. Compile o projeto usando Maven:
   ```
   mvn clean install
   ```

## Execução

Para executar a aplicação, use o seguinte comando:
```
java -jar target/OceanBlueJava-1.0-SNAPSHOT.jar
```

### Membros
- Caíque Walter Silva - RM550693
- Guilherme Nobre Bernardo - RM98604
- Matheus José de Lima Costa - RM551157

### 2ESPX