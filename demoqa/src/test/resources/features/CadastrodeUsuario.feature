#language: pt
@cadastro
	Funcionalidade: cadastrar um novo formulario
		Como usuario 
		Quero preencher todos os dados do formulario
		Para realizar o envio e cadastro

		Cenario: enviar formulario preenchido
			Dado que o usuario esteja no formulario de cadastro
			Quando preencher todos os campos obrigatorios
			E enviar os dados 
			Entao validamos os dados cadastrados

   
