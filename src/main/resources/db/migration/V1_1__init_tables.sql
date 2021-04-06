CREATE TABLE public.role (
    id          BIGSERIAL,
    name        VARCHAR (50),
    PRIMARY KEY (id)
);

CREATE TABLE public.users (
    id              BIGSERIAL,
    first_name      VARCHAR (50),
    last_name       VARCHAR (50),
    email           VARCHAR (50),
    password        text,
    active          BOOLEAN,
    role_id         BIGINT,
    PRIMARY KEY (id),
    foreign key (role_id) references public.role (id)
);

CREATE TABLE public.maker (
    id              BIGSERIAL,
    name            VARCHAR (50),
    CONSTRAINT pk_maker PRIMARY KEY (id)
);


CREATE TABLE public.motor (
    id          BIGSERIAL,
    name        VARCHAR (50),
    power       INT,
    torque      INT,
    type        VARCHAR (50),
    CONSTRAINT pk_motor PRIMARY KEY (id)
);

CREATE TABLE public.owner (
    id                  BIGSERIAL,
    first_name          VARCHAR (50),
    last_name           VARCHAR (50),
    oib                 VARCHAR (10),
    CONSTRAINT ok_owner PRIMARY KEY (id)
);

CREATE TABLE public.car (
    id                   BIGSERIAL,
    model_name           VARCHAR (50),
    color                VARCHAR (50),
    manufacture_date     DATE,
    maker_id             BIGSERIAL,
    owner_id             BIGSERIAL,
    motor_id             BIGSERIAL,
    CONSTRAINT ok_car PRIMARY KEY (id),
    CONSTRAINT fk_car_maker FOREIGN KEY (maker_id)
        REFERENCES public.maker (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_car_owner FOREIGN KEY (owner_id)
        REFERENCES public.owner (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_car_motor FOREIGN KEY (motor_id)
        REFERENCES public.motor (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
    );