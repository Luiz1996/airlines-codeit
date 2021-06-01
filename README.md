# Airlines Company(CodeIT)

## Descrição

```bash
A Airlines Company é uma empresa de aviação que opera rotas internacionais a partir de Maringá(PR).
	
Cada voo é tripulado por seis elementos, sendo que estes se dividem em dois grupos: a tripulação
técnica e a tripulação de cabine. A tripulação técnica é constituída pelo piloto e dois oficiais. A
tripulação de cabine é constituída pelo chefe de serviço de voo e duas comissárias.
	
O transporte dos tripulantes entre o terminal e o avião é efetuado através de um Smart Fortwo, que
é um veículo que leva apenas duas pessoas. Por política da empresa, apenas o piloto e o chefe de
serviço de voo podem dirigir este veículo. É também política da empresa que nenhum dos oficiais
pode ficar sozinho com o chefe de serviço de bordo, e nem nenhuma das comissárias pode ficar
sozinha com o piloto.
	
No terminal de embarque estão os seis tripulantes e ainda um policial junto com um presidiário.
Estes oito elementos terão que embarcar segundo as regras descritas acima. A empresa não coloca
nenhum limite para o número de viagens entre o terminal e o avião.
	
Por motivos de segurança o presidiário não pode ficar sozinho em momento algum com os
tripulantes sem a presença de um policial, nem no terminal e nem no avião. De forma a facilitar o
processo, a empresa autorizou que o policial pudesse dirigir o veículo também.
```

## Testes
Os cenários foram criados com base na ida/volta do Smart Fortwo:

```bash
Caso de sucesso:
	2, 5, 0, 2, 5, 0, 1, 2, 0, 2, 2, 0, 2, 2, 0, 0, 0, 0, 1, 0
		
Casos de Falha(Ida até o avião):
	- Policial e Presidiário separados:
		0, 1
	
	- 1 comissária e 1 piloto juntos:
		1, 5 e
		2, 5, 0, 2, 2, 0
			
	- 2 comissárias e 1 piloto juntos:	
		2, 5, 0, 2, 5, 0, 2, 2, 0
			
	- 1 oficial e 1 chefe juntos:
		2, 3 e
		1, 2, 0, 2, 3, 0
			
	- 2 oficiais e 1 chefe juntos:	
		1, 2, 0, 2, 2, 0, 2, 2, 0
		
Casos de Falha(Volta ao terminal):
	- Policial e Presidiário separados:
		1, 2, 0, 1, 3, 0, 1, 4, 0, 0, 0, 0, 1, 1, 0
		
	- 1 comissária e 1 piloto juntos:
		2, 5, 0, 2, 2, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1
			
	- 2 comissárias e 1 piloto juntos:	
		2, 2, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 2, 2
			
	- 1 oficial e 1 chefe juntos:
		1, 2, 0, 1, 3, 0, 2, 4, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1
			
	- 2 oficiais e 1 chefe juntos:	
		2, 5, 0, 2, 5, 0, 1, 4, 0, 0, 0, 0, 1, 2, 1
```

## Executar Projeto

```bash
Passos para execução:
	
	- Clonar este repositório
	- Ter NetBeans 8.2(ou superior) instalado em seu computador
	- Importar o projeto em NetBeans / Arquivo(File) / Abrir Projeto(Open Project) / ...
	- Limpar e Contruir o projeto(Shift + F11)
	- Executar projeto(F6)
```
