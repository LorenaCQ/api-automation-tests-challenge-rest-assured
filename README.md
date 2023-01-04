<h1>📋 TO DO</h1>

- Fazer sua collections usando a API Restful-booker
- Exportar a collection
- Subir a collection no repositório

<h3>✔️ Contida na pasta Postman: A collection foi feita no Postman e exportada como arquivo .json </h3>
Sobre Restful-booker:
É uma API de teste criada para que possa ser utilizada em testes de integração e testes de aceitação. Ela permite que você faça operações CRUD (criar, ler, atualizar e deletar) em Bookings, criar usuários, autenticar usuários e muito mais. A API foi criada para simular uma aplicação real, e por isso ela possui regras de negócio e validações para garantir que os dados enviados para a API estejam corretos e seguindo as regras da aplicação. Alguns exemplos de operações que você pode realizar na API incluem criar um novo Booking, obter informações de um Booking existente, atualizar as informações de um Booking ou deletar um Booking.

<h1> 👩‍💻 Automatizando com Rest Assured</h1>

Rest Assured é uma biblioteca Java que é usada para testar APIs REST. Ela permite que você envie solicitações HTTP para uma API e verifique se a resposta é o que você espera. Rest Assured facilita muito o processo de validação de respostas HTTP, pois fornece uma interface simples e intuitiva para isso. Além disso, é possível realizar vários tipos de validação, como verificar o código de status HTTP, os cabeçalhos da resposta e o corpo da resposta. Rest Assured também oferece suporte a vários formatos de dados, como JSON e XML.

<h4>🟩 As descrições a seguir são referentes aos códigos de automatização com Rest Assured utilizando a API Restful-booker</h4>

➔ Caminho dos códigos descritos: /src/main/java/Entities

<h2>Booking</h2>

A classe Java chamada Booking, representa uma reserva em um sistema de reservas de hospedagem. A classe possui diversos atributos, como nome e sobrenome do hóspede, preço total da reserva, informação sobre se o depósito já foi pago, detalhes da data da reserva (classe BookingDates) e informações adicionais. Ela também possui métodos getters e setters para cada atributo, permitindo obter e alterar os valores destes atributos.

<h2>BookingDates</h2>

A classe BookingDates representa a data de check-in e check-out de uma reserva (ou booking, em inglês). Ela possui dois atributos, checkin e checkout, ambos do tipo String, que armazenam essas informações.

Ela possui um construtor que recebe os valores dessas variáveis como parâmetros e os atribui aos atributos da classe. Além disso, possui métodos getters e setters para esses atributos, permitindo acessar ou modificar os valores das datas de check-in e check-out.

<h2>User</h2>

A classe User representa um usuário com os seguintes atributos:

- username: nome de usuário do usuário
- firstName: primeiro nome do usuário
- lastName: sobrenome do usuário
- email: email do usuário
- password: senha do usuário
- phone: telefone do usuário

Essa classe possui um construtor que recebe esses atributos como parâmetros e os atribui aos respectivos campos da classe. Além disso, há um método getter e um setter para cada um desses atributos. Isso permite que outras classes possam acessar e modificar os valores dos atributos de um objeto User.
