-- changeset out-gerasimov-kv:1604405505632-13
ALTER TABLE user_cart_cart
    DROP CONSTRAINT fk_ucc_product,
    ADD CONSTRAINT fk_ucc_product_2 FOREIGN KEY (cart_id) REFERENCES product (id) ON UPDATE NO ACTION ON DELETE CASCADE;
-- rollback ALTER TABLE user_cart_cart DROP CONSTRAINT fk_ucc_product_2, ADD CONSTRAINT fk_ucc_product FOREIGN KEY (cart_id) REFERENCES product (id) ON UPDATE NO ACTION ON DELETE NO ACTION;