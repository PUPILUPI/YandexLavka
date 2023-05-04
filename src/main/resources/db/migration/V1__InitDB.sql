CREATE TABLE orders (
                        order_id BIGSerial PRIMARY KEY,
                        weight FLOAT NOT NULL,
                        regions INT NOT NULL,
                        delivery_hours TEXT[] NOT NULL,
                        cost INT NOT NULL,
                        completed_time TIMESTAMP
);
CREATE TABLE couriers (
                          courier_id BIGINT PRIMARY KEY,
                          courier_type VARCHAR(20) NOT NULL CHECK (courier_type IN ('FOOT', 'BIKE', 'AUTO')),
                          regions INT[] NOT NULL,
                          working_hours TEXT[] NOT NULL
);
