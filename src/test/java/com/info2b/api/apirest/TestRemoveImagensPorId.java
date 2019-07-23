package com.info2b.api.apirest;

import com.info2b.api.apirest.models.Imagens;
import com.info2b.api.apirest.repository.ImagensRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;



@RunWith(SpringRunner.class)
@DataJpaTest
public class TestRemoveImagensPorId {

    @Autowired
    private ImagensRepository repository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void testDeleteImagemById(){

        Imagens img = new Imagens("Homem e Lobo", "https://www.tediado.com.br/wp-content/uploads/2018/06/fotos-legais-que-comprovam-que-angulo-certo-tudo-19.jpg", "Um homem e um lobo legal");
        this.repository.save(img);
        this.repository.deleteById(img.getId());
        Assertions.assertThat(this.repository.findById(img.id)).isNull();


    }
}
