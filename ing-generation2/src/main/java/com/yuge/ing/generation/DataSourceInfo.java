package com.yuge.ing.generation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataSourceInfo {
    private String url;
    private String userName;
    private String password;
}
