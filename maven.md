# Maven

Link para o curso: https://unibb.alura.com.br/course/maven-gerenciamento-dependencias-build-aplicacoes-java

## Conhecendo

<details><summary>Antes do Maven havia</summary>Apache Ant que tinha um passo a passo automatizado para buildar. build.xml 

Também tinha o Apache Ivy para gerenciar dependências que o Ant não fazia ivy.xml

Dai surgiu o Apache Maven (Ant + Ivy)
</details>

<details><summary>A partir da onde é executado?</summary>
Pode ser do prompt, mas já é integrado nas IDEs

New Project > (maven archetypes) ou (maven simples)
</details>

<details><summary>Forms iniciais do maven</summary>
Group ID: br.com.bb
Artifact ID: loja   (nome único do programa)
</details>

<details><summary>Packaging</summary>
war é para web
jar é comum e também para projetos Spring
</details>

<details><summary>pom.xml</summary>
tem as infos do form inicial
Configs para build e dependencies
pode mudar as pastas padrões
</details>

<details><summary>estrutura de diretório</summary>
src/main/java   classes, interfaces, enums
src/main/resources  configs, htmls...
</details>
