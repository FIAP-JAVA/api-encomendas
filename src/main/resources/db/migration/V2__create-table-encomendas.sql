CREATE TABLE encomendas (
    id SERIAL PRIMARY KEY,
    morador_id BIGINT NOT NULL,
    descricao VARCHAR(255),
    status VARCHAR(20),
    data_recebimento TIMESTAMP,
    data_notificacao TIMESTAMP,
    data_confirmacao_notificacao TIMESTAMP,
    data_retirada TIMESTAMP,
    recebida_por VARCHAR(100),
    CONSTRAINT fk_encomenda_morador FOREIGN KEY (morador_id) REFERENCES moradores(id)
);