insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into estado (id, nome) values (1, 'Minas Gerais');
insert into estado (id, nome) values (2, 'São Paulo');
insert into estado (id, nome) values (3, 'Ceará');

insert into cidade (id, nome, estado_id) values (1, 'Campina Verde', 1);
insert into cidade (id, nome, estado_id) values (2, 'Ituiutaba', 1);
insert into cidade (id, nome, estado_id) values (3, 'Uberlandia', 1);
insert into cidade (id, nome, estado_id) values (4, 'Belo Horizonte', 1);
insert into cidade (id, nome, estado_id) values (5, 'São Paulo', 2);
insert into cidade (id, nome, estado_id) values (6, 'Campinas', 2);
insert into cidade (id, nome, estado_id) values (7, 'Fortaleza', 3);

insert into restaurante (id, nome, taxa_frete, cozinha_id, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values (1, 'Thai Gourmet', 10, 1, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (2, 'Restaurante Tai Tai', 5.00, 1);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (3, 'Restaurante Tic Tic', 5.30, 2);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (4, 'Thai Delivery', 9.50, 1);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (5, 'Tuk Tuk Comida Indiana', 15, 2);

insert into forma_pagamento (id, descricao) values (1, 'Cartão de crédito');
insert into forma_pagamento (id, descricao) values (2, 'Cartão de débito');
insert into forma_pagamento (id, descricao) values (3, 'Dinheiro');
insert into forma_pagamento (id, descricao) values (4, 'cheque');

insert into permissao (id, nome,  descricao) values (1, 'USUARIO', 'acesso de usuario comum');
insert into permissao (id, nome, descricao) values (2, 'ADMINISTRADOR', 'acesso de administrador do sistema');
insert into permissao (id, nome, descricao) values (3, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (5, 'EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1,1), (1,2), (1,3), (2,3), (3,2), (3,3);