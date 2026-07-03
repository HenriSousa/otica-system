# AI DEVELOPMENT GUIDE
## Ótica System

Este documento contém as regras obrigatórias para qualquer IA que venha desenvolver funcionalidades neste projeto.

---

# Objetivo do Projeto

O Ótica System é um ERP/POS especializado para óticas.

O objetivo não é apenas possuir CRUDs, mas desenvolver um sistema comercial moderno, escalável e preparado para produção.

---

# Stack Tecnológica

Backend

- Java 17
- Spring Boot 3
- Spring Data JPA
- Hibernate
- Maven

Frontend

- Angular 17
- TypeScript
- SCSS
- RxJS
- Standalone Components

Banco

- Atualmente MySQL
- Futuramente PostgreSQL

---

# Arquitetura

Toda implementação deve seguir obrigatoriamente:

- DDD
- SOLID
- Clean Code
- Repository Pattern
- Service Layer
- DTO Pattern
- RESTful API

Nunca implementar lógica de negócio dentro dos Controllers.

Toda regra de negócio pertence aos Services.

---

# Estrutura

Backend

Controller

↓

Service

↓

Repository

↓

Database

Frontend

Component

↓

Service

↓

API

↓

Backend

Nunca colocar lógica de negócio diretamente no HTML.

---

# Regras Gerais

Antes de implementar qualquer funcionalidade:

- analisar a estrutura existente;
- reutilizar código existente;
- evitar duplicação;
- evitar criar componentes desnecessários;
- manter padronização visual;
- preservar compatibilidade com funcionalidades existentes.

Nunca alterar módulos que não fazem parte da tarefa.

---

# Layout

Todo novo componente deve seguir o padrão visual já existente.

Utilizar:

- cards
- bordas arredondadas
- espaçamento consistente
- botões padronizados
- mesmas cores
- mesma tipografia

Caso exista um componente semelhante, reutilizar seu layout.

---

# Padrões de Código

Utilizar nomes claros.

Não utilizar abreviações.

Exemplo

Correto

customerRepository

Errado

custRepo

Métodos pequenos.

Responsabilidade única.

Evitar métodos maiores que 40 linhas.

---

# Banco de Dados

Nunca criar colunas desnecessárias.

Sempre analisar o modelo existente.

Utilizar relacionamentos quando possível.

Evitar duplicação de informações.

---

# Ordem de Serviço

Fluxo oficial

OPEN

↓

IN_PROGRESS

↓

WAITING_LABORATORY

↓

READY

↓

AWAITING_PICKUP

↓

DELIVERED

Pode ser cancelada em qualquer momento.

CANCELED

---

# CRM

Todo cálculo deve utilizar dados reais.

Nunca gerar dados fictícios.

Indicadores devem ser calculados a partir das Ordens de Serviço.

Exemplos:

Quantidade de OS

Total gasto

Ticket Médio

Última compra

Dias sem comprar

Cliente VIP

Cliente Novo

Cliente Recorrente

Cliente Inativo

---

# PDF

Os PDFs são gerados no Frontend.

Nunca mover essa responsabilidade para o Backend sem solicitação.

Existem dois modelos:

PDF Cliente

PDF Laboratório

---

# WhatsApp

Toda integração deve ficar desacoplada.

Nunca colocar chamadas diretas dentro dos Components.

Criar Service específico.

Preparar para futuras integrações:

Meta Cloud API

Evolution API

Twilio

---

# Performance

Evitar consultas N+1.

Sempre preferir consultas otimizadas.

Quando necessário utilizar JOIN FETCH ou consultas específicas.

---

# Segurança

Nunca confiar nos dados enviados pelo Frontend.

Sempre validar no Backend.

---

# Git

Cada módulo deve possuir sua própria Branch.

Exemplo

customer-module

service-order

crm-v1

crm-v2

inventory

financial

reports

whatsapp

Após testes e validação:

Merge → main

---

# README

Sempre atualizar o README-PROJECT.md quando:

novo módulo

novo endpoint

nova funcionalidade

nova dependência

mudança arquitetural

---

# Antes de finalizar qualquer tarefa

A IA deve:

✔ Compilar o Backend

✔ Compilar o Frontend

✔ Verificar erros

✔ Atualizar README

✔ Informar arquivos alterados

✔ Explicar resumidamente as alterações

---

# Nunca fazer

Não remover funcionalidades existentes.

Não alterar layout sem necessidade.

Não criar código duplicado.

Não ignorar arquitetura existente.

Não criar consultas ineficientes.

Não utilizar dados fictícios.

Não alterar nomes de endpoints existentes.

---

# Sempre fazer

Seguir SOLID.

Seguir DDD.

Seguir Clean Code.

Manter código legível.

Reutilizar componentes.

Documentar alterações.

---

# Objetivo Final

Desenvolver um ERP moderno para óticas, escalável, organizado, preparado para produção, com arquitetura limpa e de fácil manutenção.

Toda implementação deve priorizar:

qualidade

performance

escalabilidade

organização

manutenibilidade

experiência do usuário

# Filosofia do Projeto

Antes de escrever código, a IA deve agir como um Engenheiro de Software Sênior.

Perguntas obrigatórias antes de implementar:

- Existe algo semelhante no projeto?
- Posso reutilizar algum componente?
- Essa solução escala?
- Estou seguindo o padrão visual?
- Estou respeitando DDD?
- Estou respeitando SOLID?
- Existe risco de quebrar alguma funcionalidade?
- Posso simplificar a implementação?
- Essa é a melhor solução pensando no longo prazo?

Se alguma resposta for negativa, a IA deve revisar a implementação antes de gerar código.