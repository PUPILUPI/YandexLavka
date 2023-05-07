CREATE TABLE orders
(
    id             BIGSerial PRIMARY KEY,
    weight         FLOAT  NOT NULL,
    regions        INT    NOT NULL,
    cost           INT    NOT NULL,
    completed_time TIMESTAMP
);
CREATE TABLE couriers
(
    id            BIGSERIAL PRIMARY KEY,
    courier_type  VARCHAR(20) NOT NULL CHECK (courier_type IN ('FOOT', 'BIKE', 'AUTO'))
);
CREATE TABLE courier_schedule
(
    id         BIGSERIAL PRIMARY KEY,
    courier_id BIGINT REFERENCES couriers (id),
    from_time      time NOT NULL,
    to_time         time NOT NULL
);
CREATE TABLE courier_regions
(
    id         BIGSERIAL PRIMARY KEY,
    courier_id BIGINT REFERENCES couriers (id),
    zipcode INT NOT NULL
);

CREATE TABLE order_time
(
    id       BIGSERIAL PRIMARY KEY,
    order_id BIGINT REFERENCES orders (id),
    from_time     time NOT NULL,
    to_time       time NOT NULL
);