<h1>📋 Exercícios obrigatórios</h1>

<h3>🟩 Conhecendo a API</h3>

➔ A base para qualquer teste automatizado é o teste
manual, portanto exploraremos a API
primeiramente no Postman.

➔ TO DO:<br>
◆ Fazer sua collection usando a API
Restful-booker.<br>
◆ Exportar a collection.<br>
◆ Subir sua collection no repositório.

<h3>🟩 Automatizando com Rest Assured</h3>

➔ TO DO:<br>
◆ Fazer uma suíte de testes cobrindo todos
os endpoints da documentação.<br>
◆ Gerar o report usando o Allure Framework.<br>
◆ Subir o projeto para o repositório.<br>

<h3>✔️ Contida na pasta Postman: A collection foi feita no Postman e exportada como arquivo .json </h3>
Sobre Restful-booker:
É uma API de teste criada para que possa ser utilizada em testes de integração e testes de aceitação. Ela permite que você faça operações CRUD (criar, ler, atualizar e deletar) em Bookings, criar usuários, autenticar usuários e muito mais. A API foi criada para simular uma aplicação real, e por isso ela possui regras de negócio e validações para garantir que os dados enviados para a API estejam corretos e seguindo as regras da aplicação. Alguns exemplos de operações que você pode realizar na API incluem criar um novo Booking, obter informações de um Booking existente, atualizar as informações de um Booking ou deletar um Booking.

<h1> 👩‍💻 Automatizando com Rest Assured</h1>

Rest Assured é uma biblioteca Java que é usada para testar APIs REST. Ela permite que você envie solicitações HTTP para uma API e verifique se a resposta é o que você espera. Rest Assured facilita muito o processo de validação de respostas HTTP, pois fornece uma interface simples e intuitiva para isso. Além disso, é possível realizar vários tipos de validação, como verificar o código de status HTTP, os cabeçalhos da resposta e o corpo da resposta. Rest Assured também oferece suporte a vários formatos de dados, como JSON e XML.

<h4>🟩 As descrições a seguir são referentes às classes criadas tomando como referência a API Restful-booker</h4>

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

<h4>🟩 As descrições a seguir são referentes à classe criada para fazer automação dos testes</h4>

<h2>BookingTests</h2>

➔ Caminho do código descrito: /src/test/java/

Este código é uma classe de teste JUnit para testar uma API de reservas.

A classe importa três outras classes: Booking, BookingDates e User. Essas classes representam os objetos de reserva, datas de reserva e usuário, respectivamente. A classe também importa a biblioteca Faker para gerar dados aleatórios para preencher esses objetos.

A classe também importa a biblioteca RestAssured, que é usada para fazer solicitações HTTP à API de reserva de hotel. A classe também usa os filtros RequestLoggingFilter, ResponseLoggingFilter e ErrorLoggingFilter da biblioteca RestAssured para registrar solicitações, respostas e erros durante os testes.

A classe possui 7 métodos de teste: createAuthToken_returnOk, getAllBookingsById_returnOk, getAllBookingsByUserFirstName_BookingExists_returnOk, createBooking_WithValidData_returnOk, updateBooking_WithValidData_returnOk, partialUpdateBooking_WithValidData_returnOk, deleteBooking_WithValidData_returnOk. Cada método de teste envia uma solicitação HTTP à API de reserva de hotel e verifica se a resposta é válida.

O método Setup() é executado antes de todos os outros testes e é responsável por configurar o RestAssured.baseURI e instanciar o objeto faker da classe Faker. Além disso, ele também cria uma reserva, uma data de reserva e um usuário, que são utilizados nos testes posteriores.

O método setRequest() é executado antes de cada teste e é responsável por configurar a especificação da solicitação para o teste atual.

O método createAuthToken_returnOk() testa se a autenticação é bem-sucedida, enviando uma solicitação POST com as credenciais de administrador para a API e verificando se a resposta tem código de status 200 (OK). Se for bem-sucedido, o token de autenticação é armazenado para uso posterior.

O método getAllBookingsById_returnOk() testa se é possível obter todas as reservas enviando uma solicitação GET para a API e verificando se a resposta tem código de status 200 (OK).

O método getAllBookingsByUserFirstName_BookingExists_returnOk() testa se é possível obter reservas por nome do usuário, enviando uma solicitação GET com o parâmetro firstName para a API e verificando se a resposta tem código de status 200 (OK).

Os outros métodos funcionam da mesma forma, testando diferentes funcionalidades da API de reserva. Ao final de cada método de teste, há uma verificação de asserção para garantir que o resultado seja o esperado.

O método setRequest é executado antes de cada método de teste e inicializa o objeto request com as configurações padrão para as solicitações HTTP (como o tipo de conteúdo e autenticação básica).