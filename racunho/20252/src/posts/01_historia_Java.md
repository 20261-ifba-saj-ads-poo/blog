---
icon: edit
date: 2025-10-20 17:41:00.00 -3
tag:
  - java
  - paradigmas
category:
  - aula
order: 1
---

# História do Java

Nesse capítulo teremos um compilado de informações que foram reunidas de vários lugares ([^Deitel], [^Dornelles], [^Oracle], [^Santos]). Bons Estudos.

## Por que Java?

Existem diversas linguagens de programação orientadas a objeto, cada uma com diferentes características e apelos de mercado, educacionais ou acadêmicos. Segue, algumas das razões da escolha da linguagem Java.

**Java é obrigatoriamente orientada a objetos**: Algumas linguagens permitem que objetos e variáveis existam em diversos pontos de um programa, como se estivessem desatreladas de qualquer estrutura. Em Java, todas as variáveis e métodos devem estar localizados dentro de classes, forçando o uso de orientação a objetos até mesmo em tarefas simples. Dessa forma, o estudante de programação orientada a objetos que esteja usando Java estará usando mais as técnicas de POO.

**Java é simples**: A estrutura de programas e classes em Java segue a organização de linguagens tradicionais como C e C++, mas sem elementos que tornam programas e programação mais complexos. Após o aprendizado dos conceitos básicos de programação orientada a objetos, o estudante da linguagem pode começar a criar aplicativos úteis e complexos. A simplicidade se reflete também na maneira com que arquivos contendo programas em Java são compilados e executados: se as recomendações básicas forem seguidas, o compilador se encarregará de compilar todas as classes necessárias em uma aplicação automaticamente, sem necessidade de arquivos adicionais de configuração e inclusão de bibliotecas.

**Java é portátil**: O código-fonte de um programa ou classe em Java pode ser compilado em qualquer computador, usando qualquer sistema operacional, contanto que este tenha uma máquina virtual Java adequada. Adicionalmente, as classes criadas podem ser copiadas e executadas em qualquer computador nas mesmas condições, aumentando a utilidade da linguagem através da independência de plataformas, contanto que versões compatíveis da máquina virtual sejam usadas. 

**Java é gratuita**: A máquina virtual Java, mencionada acima, está à disposição para cópia no site da Oracle e em vários outros. Compiladores simples, de linha de comando (sem interfaces visuais elaboradas) fazem parte do JDK, o ambiente de desenvolvimento gratuito de Java. Aplicações em Java precisam de uma máquina virtual para sua execução, mas não existem limitações na distribuição da máquina virtual, fazendo de Java uma plataforma extremamente econômica para desenvolvedores e usuários finais.

**Java é robusta**: Administração de memória (alocação e liberação) e o uso de ponteiros, duas das fontes de erros e bugs mais frequentes em programas em C e C++, são administrados internamente na linguagem, de forma transparente para o programador. De maneira geral, programas em Java tem restrições no acesso à memória que resultam em maior segurança para os programas sem diminuir a utilidade dos mesmos. Java também tem um poderoso mecanismo de exceções que permite melhor tratamento de erros em tempo de execução dos programas.

**Java tem bibliotecas prontas para diversas aplicações**: As bibliotecas de classes de Java contém várias classes que implementam diversos mecanismos de entrada e saída, acesso à Internet, manipulação de Strings em alto nível, poderosas estruturas de dados, utilitários diversos e um conjunto completo de classes para implementação de interfaces gráficas. Vale a pena relembrar que estas bibliotecas são padrão de Java - qualquer máquina virtual Java permite o uso destas bibliotecas, sem a necessidade de instalar pacotes adicionais, e que mesmo que o compilador usado não tenha interface gráfica similar à de linguagens visuais, os programas criados com este compilador podem ter interfaces gráficas complexas.


## História

A história da tecnologia Java começou modestamente no final de 1990, quando a empresa Sun Microsystems encarregou seus funcionários Patrick Naughton, Mike Sheridan e James Gosling da tarefa de descobrir qual seria a próxima grande tendência na área da computação. O projeto, denominado "Green Project", chegou à seguinte conclusão preliminar: a integração dos dispositivos controlados digitalmente com os computadores iria se tornar uma tendência muito importante.

Aquele revolucionário dispositivo remoto, conectado à rede sem fio, rodava uma versão do sistema operacional Unix e possuía uma tela sensível ao toque (touchscreen) – lembre-se que estávamos em 1992 e, para se ter uma ideia do desenvolvimento da Internet naquela época, basta dizer que, no final do ano, havia apenas 26 servidores Web no mundo! A interface de usuário incluía também um assistente de ajuda: um simpático personagem de desenho animado chamado **Duke,** que mais tarde seria adotado como mascote da plataforma Java.

O Star 7 incorporava "uma nova linguagem de programação dinâmica, compacta, segura, distribuída, robusta, interpretada, incorporando garbage collection e multi-threading, neutra à arquitetura de hardware e de alto desempenho" a fim de solucionar os vários problemas pertinentes ao desenvolvimento de programas para execução na plataforma Star 7. James Gosling criou a linguagem e deu-lhe o nome de "Oak", em homenagem a um enorme carvalho que podia ser visto da janela do seu escritório.

O "Green Project" teve o seu grande momento de glória e surgiu a oportunidade de produzir dispositivos similares ao Star 7 para consumidores em potencial na indústria de TV a cabo. "Equipe Green" mudou de nome para "FirstPerson" e preparou um filme para demonstração da sua tecnologia aos produtores de transcodificadores de TV e aluguel de vídeo. Mas, infelizmente para a equipe, aqueles setores, ainda na sua infância, estavam em processo de criação de modelos de negócio viáveis. A despeito do insucesso da "FirstPerson" com a TV a cabo, o tipo de configuração da sua tecnologia de rede era idêntica à configuração de rede para a Internet, que passava por um avassalador processo de popularização.

A Internet usava a *HyperText Markup Language* (HTML) para transportar o conteúdo de mídia – texto, vídeo, imagens, áudio, etc. – através de uma rede de dispositivos heterogêneos. De uma forma similar, Java (um nome substituto para Oak, a fim de contornar problemas de natureza legal com outra linguagem de nome idêntico) também movimentava o conteúdo de mídia através de uma rede de dispositivos heterogêneos, mas ia além: transportava também o seu "comportamento", na forma de applets. A linguagem HTML não conseguia fazer isso.

Para demonstrar a utilidade de Java numa Web baseada na Internet, a "FirstPerson" fez um clone do navegador Mosaic e, em 1994, o navegador WebRunner (mais tarde conhecido como HotJava), "deu vida, pela primeira vez, a objetos animados e a conteúdo executável dinamicamente dentro de um navegador."

John Gage, diretor do Escritório de Ciências da Sun, e James Gosling, fizeram uma demonstração do WebRunner numa reunião com profissionais da Internet e da área de entretenimento no início de 1995. A plateia aplaudiu calorosamente as demonstrações de uma molécula tridimensional giratória e a animação de um algorítimo de ordenação preparado por Gosling, embutidas em páginas Web apresentadas no WebRunner. O futuro certamente havia chegado. A notícia se espalhou rapidamente, e a "FirstPerson" disponibilizou o WebRunner para download.

Milhares de downloads chamaram a atenção da Sun para a popularidade de Java, e ela disponibilizou uma área no seu site para divulgar essa tecnologia. Em maio de 1995, durante a abertura da feira SunWorld da Sun, o líder do projeto Netscape, Marc Andreessen, anunciou que iriam integrar Java ao novo navegador para a Web Netscape.


### A aquisição da Sun Microsystems pela Oracle (2008)
Em 2008, a Oracle adquiriu a Sun Microsystems por US$ 7,4 bilhões, tornando-se proprietária do Java e de suas tecnologias associadas. A Sun, criadora do Java em 1995, já havia estabelecido a linguagem como uma das mais populares do mundo, com foco em portabilidade e uso em dispositivos embarcados, internet e sistemas corporativos via Java EE (Enterprise Edition).

A Oracle assumiu o controle do desenvolvimento da linguagem, incluindo as especificações do Java EE, que eram críticas para aplicações empresariais. Inicialmente, houve preocupações na comunidade sobre a gestão da Oracle, conhecida por seu modelo comercial fechado, em contraste com a cultura mais aberta da Sun.

### A briga judicial entre Oracle e Google (2010–2021)

O conflito começou em 2010, quando a Oracle processou o Google por usar APIs do Java SE no Android sem licença. O Google havia implementado 37 pacotes de APIs do Java (cerca de 11 mil linhas de código) para permitir que desenvolvedores migrassem aplicativos para o Android.

Principais pontos do caso:

**Direitos autorais de APIs**: A Oracle alegou que as APIs eram protegidas por copyright, enquanto o Google argumentou que seu uso se enquadrava no "fair use" (uso justo), essencial para a interoperabilidade.

**Decisões judiciais**: Em 2012, um júri considerou o uso do Google legal, mas em 2014 um tribunal reverteu a decisão, afirmando que APIs poderiam ser protegidas. Em 2021, a Suprema Corte dos EUA decidiu, por 6 votos a 2, que o uso das APIs pelo Google era "transformativo" e justo, encerrando a disputa após 11 anos.

**Impacto no Android**: Após a decisão, o Google migrou para o OpenJDK (versão open-source do Java), evitando futuros conflitos.

### Impactos na evolução do Java EE e o surgimento do Jakarta EE

A aquisição pela Oracle e o foco em litígios afetaram diretamente o desenvolvimento do Java EE (Enterprise Edition), usado para aplicações corporativas.
Principais eventos:

**Estagnação do Java EE**: Sob a Oracle, o Java EE 8 (lançado em 2017) teve progresso lento, com poucas inovações para demandas modernas como computação em nuvem e microsserviços. A comunidade criticou a falta de investimento da Oracle.

**Doação para a Eclipse Foundation**: Em 2017, a Oracle doou o Java EE para a Eclipse Foundation, que o rebatizou como Jakarta EE devido a restrições de marca (a Oracle manteve o nome "Java").

### Renascimento como Jakarta EE

O Jakarta EE priorizou a modernização, com foco em:

**Cloud-native e microsserviços**: Adaptação para containers (Docker/Kubernetes) e integração com ferramentas como Eclipse MicroProfile12.

**Licenciamento aberto**: As especificações, kits de compatibilidade (TCKs) e implementações de referência tornaram-se open source, promovendo colaboração entre empresas como Red Hat, IBM e Microsoft69.

**Mudanças de nomenclatura**: APIs migraram do pacote javax.* para jakarta.* para evitar conflitos legais39.

### Consequências para o ecossistema Java

Fragmentação e união: A briga Oracle-Google levantou debates sobre direitos autorais de código, mas a vitória do Google fortaleceu a interoperabilidade. Já a transição para o Jakarta EE unificou comunidades antes divididas (como Spring e Java EE).

**Inovação acelerada**: O Jakarta EE adotou ciclos de lançamento mais rápidos, com versões como EE 9 (2020) e EE 10 (2022), introduzindo suporte a Java SE 17, CDI 4.0 e melhorias para cloud.

**Adoção empresarial**: Empresas como Red Hat e IBM passaram a liderar o desenvolvimento, garantindo que o Jakarta EE atendesse a demandas reais do mercado, como segurança escalável e integração com Kubernetes.


## Máquina Virtual

Em uma linguagem de programação como C e Pascal, temos a seguinte situação quando vamos compilar um programa:

<figure>

```plantuml
@startuml
node "Código binário para \nS.O. específico" as n1
artifact f1 as "Código fonte \nem C"
f1 -> n1 : compilação
@enduml
```

<figcaption> Representação do processo de compilação.</figcaption>
</figure>

O código fonte é compilado para código de máquina específico de uma plataforma e sistema operacional.

Muitas vezes o próprio código fonte é desenvolvido visando uma única plataforma!

Esse código executável (binário) resultante será executado pelo sistema operacional e, por esse motivo, ele deve saber conversar com o sistema operacional em questão.

<figure>

```plantuml
@startuml

!define SPRITESURL https://raw.githubusercontent.com/plantuml-stdlib/gilbarbara-plantuml-sprites/v1.0/sprites
!includeurl SPRITESURL/microsoft-windows.puml
!includeurl SPRITESURL/ubuntu.puml
!includeurl SPRITESURL/apple.puml


skinparam monochrome false

artifact f1 as "Código fonte \nem C'"
artifact f2 as "Código fonte \nem C''"
artifact f3 as "Código fonte \nem C'''"

node "exe" as b1
node "bin" as b2
node "app" as b3

rectangle "<$microsoft-windows>" as exe
rectangle "<$ubuntu>" as bin
rectangle "<$apple>" as app
f1-->b1
f2-->b2
f3-->b3

b1-->exe
b2-->bin
b3-->app
@enduml
```


<figcaption> Aplicação associada ao Sistema Operacional.</figcaption>
</figure>

Isto é, temos um código executável para cada sistema operacional. É necessário compilar uma vez para Windows, outra para o Linux, e assim por diante, caso a gente queira que esse nosso software possa ser utilizado em várias plataformas. Esse é o caso de aplicativos como o Eclipse, Firefox e outros.

Como foi dito anteriormente, na maioria das vezes, a sua aplicação se utiliza das bibliotecas do sistema operacional, como, por exemplo, a de interface gráfica para desenhar as "telas". A biblioteca de interface gráfica do Windows é bem diferente das do Linux: como criar então uma aplicação que rode de forma parecida nos dois sistemas operacionais?

Precisamos reescrever um mesmo pedaço da aplicação para diferentes sistemas operacionais, já que eles não são compatíveis.

Já o Java utiliza do conceito de máquina virtual, onde existe, entre o sistema operacional e a aplicação, uma camada extra responsável por "traduzir" - mas não apenas isso - o que sua aplicação deseja fazer para as respectivas chamadas do sistema operacional onde ela está rodando no momento:

<figure>

```plantuml
@startuml

!define SPRITESURL https://raw.githubusercontent.com/plantuml-stdlib/gilbarbara-plantuml-sprites/v1.0/sprites
!includeurl SPRITESURL/microsoft-windows.puml
!includeurl SPRITESURL/ubuntu.puml
!includeurl SPRITESURL/apple.puml
!includeurl SPRITESURL/java.puml


skinparam monochrome false

artifact f1 as "Código fonte \nem Java"

node "Bytecode" as b1

rectangle "<$java>\n   JVM" as jvm


rectangle "<$microsoft-windows>" as exe
rectangle "<$ubuntu>" as bin
rectangle "<$apple>" as app
f1->b1
b1->jvm
jvm-->exe
jvm-->bin
jvm-->app
@enduml
```

<figcaption> Aplicação rodando em JVM.</figcaption>
</figure>


Dessa forma, a maneira com a qual você abre uma janela no Linux ou no Windows é a mesma: você ganha independência de sistema operacional. Ou, melhor ainda, independência de plataforma em geral: não é preciso se preocupar em qual sistema operacional sua aplicação está rodando, nem em que tipo de máquina, configurações, etc.

Perceba que uma máquina virtual é um conceito bem mais amplo que o de um interpretador. Como o próprio nome diz, uma máquina virtual é como um "computador de mentira": tem tudo que um computador tem. Em outras palavras, ela é responsável por gerenciar memória, threads, a pilha de execução, etc.

Sua aplicação roda sem nenhum envolvimento com o sistema operacional! Sempre conversando apenas com a Java Virtual Machine (JVM).

Essa característica é interessante: como tudo passa pela JVM, ela pode tirar métricas, decidir onde é melhor alocar a memória, entre outros. Uma JVM isola totalmente a aplicação do sistema operacional. Se uma JVM termina abruptamente, só as aplicações que estavam rodando nela irão terminar: isso não afetará outras JVMs que estejam rodando no mesmo computador, nem afetará o sistema operacional.

Essa camada de isolamento também é interessante quando pensamos em um servidor que não pode se sujeitar a rodar código que possa interferir na boa execução de outras aplicações.

Essa camada, a máquina virtual, não entende código java, ela entende um código de máquina específico. Esse código de máquina é gerado por um compilador java, como o *javac,* e é conhecido por *bytecode*, pois existem menos de 256 códigos de operação dessa linguagem, e cada "opcode" gasta um byte. O compilador Java gera esse *bytecode* que, diferente das linguagens sem máquina virtual, vai servir para diferentes sistemas operacionais, já que ele vai ser "traduzido" pela JVM.

::: tip Write once, run anywhere
Esse era um slogan que a Sun usava para o Java, já que você não precisa reescrever partes da sua aplicação toda vez que quiser mudar de sistema operacional
:::



## Java lento? Hotspot e JIT
Hotspot é a tecnologia que a JVM utiliza para detectar pontos quentes da sua aplicação: código que é executado muito, provavelmente dentro de um ou mais loops. Quando a JVM julgar necessário, ela vai compilar estes códigos para instruções realmente nativas da plataforma, tendo em vista que isso vai provavelmente melhorar a performance da sua aplicação. Esse compilador é o JIT: Just inTime Compiler, o compilador que aparece "bem na hora" que você precisa. 

Você pode pensar então: porque a JVM não compila tudo antes de executar a aplicação? É que teoricamente compilar dinamicamente, a medida do necessário, pode gerar uma performance melhor. O motivo é simples: imagine um .exe gerado pelo VisualBasic, pelo gcc ou pelo Delphi; ele é estático. Ele já foi otimizado baseado em heurísticas, o compilador pode ter tomado uma decisão não tão boa. 

Já a JVM, por estar compilando dinamicamente durante a execução, pode perceber que um determinado código não está com performance adequada e otimizar mais um pouco aquele trecho, ou ainda mudar a estratégia de otimização. É por esse motivo que as JVMs mais recentes em alguns casos chegam a ganhar de códigos C compilados com o GCC 3.x.



## Versões do Java e a confusão do Java2
Java 1.0 e 1.1 são as versões muito antigas do Java, mas já traziam bibliotecas importantes como o JDBC e o java.io. 

Com o Java 1.2 houve um aumento grande no tamanho da API, e foi nesse momento em que trocaram a nomenclatura de Java para Java2, com o objetivo de diminuir a confusão que havia entre Java e Javascript. Mas lembre-se, não há versão "Java 2.0", o 2 foi incorporado ao nome, tornando-se Java2 1.2. 

Depois vieram o Java2 1.3 e 1.4, e o Java 1.5 passou a se chamar Java 5, tanto por uma questão de marketing e porque mudanças significativas na linguagem foram incluídas. É nesse momento que o "2" do nome Java desaparece. Perceba que para fins de desenvolvimento, o Java 5 ainda é referido como Java 1.5. Hoje a última versão disponível do Java é a 20 [^java20].

[^java20]:https://www.oracle.com/news/announcement/oracle-releases-java-20-2023-03-21/



## JVM? JRE? JDK? O que devo baixar?
O que gostaríamos de baixar no site da Oracle?

JVM: Apenas a virtual machine, esse download não existe, ela sempre vem acompanhada.

JRE: Java Runtime Environment, ambiente de execução Java, formado pela JVM e bibliotecas, tudo que você precisa para executar uma aplicação Java. Mas nós precisamos de mais.

JDK: Java Development Kit: Nós, desenvolvedores, faremos o download do JDK do Java SE (Standard Edition). Ele é formado pela JRE somado a ferramentas, como o compilador. 


Tanto o JRE e o JDK podem ser baixados do site [https://adoptium.net/pt-BR](https://adoptium.net/pt-BR). 


## Referências

<!-- @include: ../../includes/bib.md -->