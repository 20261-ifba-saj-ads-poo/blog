---
icon: dumbbell
date: 2025-08-25 19:01:00.00 -3
tag:
  - exception
category:
  - exercicio
  - entrega
---

# Exercício AutenticacaoInvalidaException

Crie um código que atenda a seguinte descrição:

1. Deve existir uma classe `Usuario` que representa um usuário com login (`getLogin`) e senha (`getSenha`). 
1. Deve existir uma classe `UsuarioDAO` que irá armazenar as instancias de usuário.
    1. O método `autenticar` que realiza a autenticação, verificando se o login de usuário e a senha fornecidos correspondem a algum usuário no DAO.
1. Se a autenticação não for bem-sucedida a exceção `AutenticacaoInvalidaException` é lançada com uma mensagem de erro apropriada ("Usuario (login tal) não foi encontrado ou a senha está errada").
1. No método `main`, um exemplo de autenticação é realizado chamando o método `autenticar` do `BancoDeUsuarios` com um usuário válido. Se a autenticação for bem-sucedida, será exibida uma mensagem indicando que o usuário foi autenticado. Caso contrário, a mensagem de erro será exibida.






