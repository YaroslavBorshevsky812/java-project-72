CREATE TABLE IF NOT EXISTS urls
(
    id
    BIGINT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    name
    VARCHAR
(
    255
) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW
(
)
    );

CREATE TABLE IF NOT EXISTS url_checks
(
    id
    BIGINT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    status_code
    INT
    NOT
    NULL,
    title
    VARCHAR
(
    255
),
    h1 VARCHAR
(
    255
),
    description TEXT,
    url_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW
(
),
    FOREIGN KEY
(
    url_id
) REFERENCES urls
(
    id
)
    );