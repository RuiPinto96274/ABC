/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.time.LocalDate;

/**
 *
 * @author 
 */
public class Quota {
    //private int id_quota;
    private String username;
    private String pagou;
    private LocalDate data_pagamento;
    
    public Quota(/*int id,*/ String user, String pagou, LocalDate data){
        //this.id_quota=id;
        this.username=user;
        this.pagou=pagou;
        this.data_pagamento= data;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPagou() {
        return pagou;
    }

    public void setPagou(String pagou) {
        this.pagou = pagou;
    }

    public LocalDate getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(LocalDate data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    @Override
    public String toString() {
        return "Quota{" + "username=" + username + ", pagou=" + pagou + ", data_pagamento=" + data_pagamento + '}';
    }
    
    
    
}
