CREATE TABLE catalog_product (
    product_id BIGINT NOT NULL,
    catalog_id BIGINT NOT NULL,
    PRIMARY KEY (product_id, catalog_id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (catalog_id) REFERENCES catalog(id)
);