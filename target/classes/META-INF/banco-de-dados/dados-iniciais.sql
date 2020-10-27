insert into produto (id, nome, preco, descricao) values (1, 'Kindle', 499.0, 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into produto (id, nome, preco, descricao) values (3, 'Camera Cannon TekPix', 7599.0, 'Camera quase identica a original');

insert into cliente (id, nome) values (1, 'Luciano Carrafa');
insert into cliente (id, nome) values (2, 'Debora Carrafa');
insert into cliente (id, nome) values (3, 'Teste');

insert into pedido (id, cliente_id, data_criacao, total, status) values (1, 1, sysdate(), 100.0, 'AGUARDANDO');
insert into pedido (id, cliente_id, data_criacao, total, status) values (2, 1, sysdate(), 5000.0, 'PENDENTE');

insert into item_pedido (id, pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 1, 499.0, 2);
insert into item_pedido (id, pedido_id, produto_id, preco_produto, quantidade) values (2, 2, 3, 7590, 2);

insert into categoria (id, nome) values (1, "Eletrônicos");
