CREATE TABLE role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL
);

CREATE TABLE users (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     username VARCHAR(50) NOT NULL,
     email VARCHAR(100) NOT NULL,
     password VARCHAR(255) NOT NULL,
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
 );

 CREATE TABLE property (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     title VARCHAR(100) NOT NULL,
     description TEXT,
     location VARCHAR(100),
     price DOUBLE NOT NULL,
     is_approved BOOLEAN DEFAULT FALSE,
     owner_id BIGINT,
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     FOREIGN KEY (owner_id) REFERENCES users (id)
 );


CREATE TABLE rental_application (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(50),
    property_id BIGINT,
    tenant_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (property_id) REFERENCES property (id),
    FOREIGN KEY (tenant_id) REFERENCES users (id)
);

CREATE TABLE viewing_request (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    request_date DATE NOT NULL,
    status VARCHAR(50),
    property_id BIGINT,
    tenant_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (property_id) REFERENCES property (id),
    FOREIGN KEY (tenant_id) REFERENCES users (id)
);

CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES role (id)
);
