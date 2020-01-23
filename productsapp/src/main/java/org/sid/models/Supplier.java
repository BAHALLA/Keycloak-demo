package org.sid.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Supplier {
    private Long supplierID;
    private String supplierName;
    private String supplierEmail;
}
