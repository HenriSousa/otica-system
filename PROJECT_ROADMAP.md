# PROJECT ROADMAP
## Ótica System

> Documento responsável por definir a visão, planejamento e evolução do Ótica System.

---

# 🎯 Visão do Projeto

O **Ótica System** é um ERP/POS especializado para óticas.

O objetivo do projeto é oferecer uma plataforma moderna, intuitiva, escalável e preparada para produção, permitindo gerenciar toda a operação de uma ótica em um único sistema.

O desenvolvimento deve sempre priorizar:

- Simplicidade
- Performance
- Escalabilidade
- Clean Code
- SOLID
- DDD
- Excelente experiência do usuário (UI/UX)

---

# 📊 Status Geral do Projeto

**Progresso Geral**

🟩🟩🟩⬜⬜⬜⬜⬜⬜⬜

**30% Concluído**

---

# ✅ Módulos Concluídos

## Cadastro de Clientes

Status: ✅ Concluído

Funcionalidades:

- Cadastro
- Edição
- Exclusão
- Busca
- Visualização

---

## Ordens de Serviço

Status: ✅ Concluído

Funcionalidades:

- Cadastro
- Edição
- Visualização
- Exclusão
- Receita Óptica
- Financeiro
- Assinatura
- Status da OS

Fluxo Oficial:

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

Cancelamento permitido:

CANCELED

---

## PDFs

Status: ✅ Concluído

Documentos disponíveis:

- PDF Cliente (A4)
- PDF Laboratório (A5)

Geração realizada no Frontend.

---

## CRM V1

Status: ✅ Concluído

Funcionalidades:

- Listagem de Clientes
- Histórico de Ordens de Serviço
- Total de Compras
- Total Gasto
- Ticket Médio
- Última Compra

---

# 🚧 Módulo Atual

## CRM V2

Status:

🚧 Em Desenvolvimento

Objetivo:

Transformar o CRM em uma ferramenta comercial completa.

Atualização recente:

- Unificação da navegação para a rota principal `/crm`
- Dashboard como página central do CRM
- Organização dos cards por indicadores, perfil e operacional
- Preparação da estrutura para futuras áreas: gráficos, campanhas, WhatsApp e relatórios

Funcionalidades planejadas:

- Dashboard
- Clientes VIP
- Clientes Novos
- Clientes Inativos
- Aniversariantes
- Dias sem comprar
- Timeline do Cliente
- Preparação para WhatsApp

Prioridade:

⭐⭐⭐⭐⭐

---

# 📅 Próximos Módulos

## Estoque

Planejado

Funcionalidades:

- Produtos
- Lentes
- Armações
- Tratamentos
- Fabricantes
- Entrada
- Saída
- Inventário

Prioridade:

⭐⭐⭐⭐⭐

---

## Financeiro

Planejado

Funcionalidades:

- Contas a Receber
- Contas a Pagar
- Fluxo de Caixa
- Caixa Diário
- PIX
- Cartão
- Dinheiro
- Relatórios Financeiros

Prioridade:

⭐⭐⭐⭐⭐

---

## Relatórios

Planejado

Funcionalidades:

- Receita Mensal
- Clientes
- Produtos
- OS
- Financeiro

Prioridade:

⭐⭐⭐⭐

---

## WhatsApp

Planejado

Funcionalidades:

- Aviso de OS pronta
- Aniversariantes
- Clientes Inativos
- Promoções
- Campanhas

Integrações previstas:

- Meta Cloud API
- Evolution API
- Twilio

Prioridade:

⭐⭐⭐⭐⭐

---

## Autenticação

Planejado

Funcionalidades:

- Login
- JWT
- Controle de Permissões
- Auditoria

Prioridade:

⭐⭐⭐⭐

---

## Dashboard Executivo

Planejado

Indicadores:

- Receita
- Clientes
- OS
- Ticket Médio
- Produtos
- Financeiro

Prioridade:

⭐⭐⭐⭐

---

## PostgreSQL

Planejado

Objetivo:

Migrar o banco MySQL para PostgreSQL.

Prioridade:

⭐⭐⭐

---

## Deploy

Planejado

Objetivo:

Publicação em ambiente Cloud.

Tecnologias previstas:

- Frontend: Vercel
- Backend: Railway / Render / AWS
- Banco: PostgreSQL

Prioridade:

⭐⭐⭐⭐

---

# 💡 Ideias Futuras

- Inteligência Artificial para recomendação de lentes
- Programa de Fidelidade
- Cashback
- Portal do Cliente
- Aplicativo Mobile
- QR Code na Ordem de Serviço
- Pesquisa de Satisfação
- Assinatura Digital
- Backup Automático
- Auditoria Completa
- Integração com Nota Fiscal
- Integração com PIX
- Integração com Laboratórios

---

# 🚀 Roadmap de Versões

## v0.1

✅ Cadastro de Clientes

---

## v0.2

✅ Ordens de Serviço

---

## v0.3

✅ PDFs

---

## v0.4

✅ CRM V1

---

## v0.5

🚧 CRM V2

---

## v0.6

📅 Estoque

---

## v0.7

📅 Financeiro

---

## v0.8

📅 Relatórios

---

## v0.9

📅 WhatsApp
📅 Autenticação

---

## v1.0

Primeira versão pronta para produção contendo:

- Clientes
- Ordens de Serviço
- CRM
- Estoque
- Financeiro
- Relatórios
- Dashboard
- WhatsApp
- Login
- Permissões
- PostgreSQL
- Deploy
- Documentação Completa

---

# 🏗️ Filosofia do Produto

O Ótica System não deve ser apenas um sistema para cadastro de clientes e Ordens de Serviço.

O objetivo é se tornar uma plataforma completa de gestão para óticas, permitindo automatizar processos, melhorar o relacionamento com os clientes e aumentar a produtividade.

Toda nova funcionalidade deve agregar valor real ao usuário, mantendo simplicidade, organização e facilidade de manutenção.

---

# 📌 Regras de Evolução

Toda nova funcionalidade deve:

- Seguir o AI_DEVELOPMENT_GUIDE.md
- Atualizar o README-PROJECT.md
- Atualizar este ROADMAP quando necessário
- Ser implementada em uma Branch específica
- Ser testada antes do Merge
- Manter compatibilidade com funcionalidades existentes

---

# 🎯 Objetivo Final

Construir um ERP moderno para óticas que seja referência em:

- Organização
- Performance
- Escalabilidade
- Automação
- Experiência do Usuário
- Facilidade de Manutenção
- Arquitetura Limpa
