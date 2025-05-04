# Desmotivação API 😩

Uma API de frases **desmotivacionais** para usar em testes, bots, apps ou quando você precisa de um lembrete de que talvez as coisas não estejam indo tão bem assim.  
O conteúdo é 100% original, 100% questionável.

Este repositório contém o backend da **API pública** hospedada em [Render](https://render.com), e está disponível para uso aberto pela comunidade.  
**Você pode consumir os endpoints livremente em seus projetos.**

> ⚠️ Este projeto **aceita contribuições de novas frases** através do seguinte [formulário](https://docs.google.com/forms/d/e/1FAIpQLSdpKVqVeNkiiEwa1afxBTb9uJK4V9-rDZ5BPAe57HeBiRsY7g/viewform?usp=header).

---

## 🌐 Endpoint público

**Base URL da API:**


> [https://desmotiva-acao-api.onrender.com](https://desmotiva-acao-api.onrender.com)



---

## ✨ Exemplos de uso

**Buscar uma frase aleatória:**  
`GET /quote`

**Buscar até 20 frases aleatórias:**  
`GET /quote?limit=5`

**Buscar frases de um autor específico:**  
`GET /quote?author=Sua%20mãe`

## 🧠 Exemplo de resposta

```json
[
  {
    "id": 1,
    "text": "Seu primo já é concursado e você ainda não terminou nem a faculdade",
    "author": "Sua mãe"
  }
]
````

## 📦 Tecnologias

* [Ktor](https://ktor.io/) — Web framework em Kotlin
* [Supabase](https://supabase.com/) — Backend com PostgreSQL
* [Exposed](https://github.com/JetBrains/Exposed) — ORM Kotlin para SQL


> ⚠️ Este projeto é 100% humorístico. Use com moderação.

