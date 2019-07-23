package com.info2b.api.apirest;

import com.info2b.api.apirest.models.Imagens;
import com.info2b.api.apirest.repository.ImagensRepository;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;





@RunWith(SpringRunner.class)
@DataJpaTest
public class TestBuscarImagensPorId {

    @Autowired
    private ImagensRepository repository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testGetByIdImagens(){

        Imagens img = new Imagens("Leão", "https://abrilexame.files.wordpress.com/2017/12/sd_2712.jpg","Um Leão dahora");
        this.repository.save(img);
        Imagens img2 = this.repository.findById(img.getId());
        Assertions.assertThat(img2.getTitulo()).isEqualTo("Leão");
        Assertions.assertThat(img2.getUrl()).isEqualTo("https://abrilexame.files.wordpress.com/2017/12/sd_2712.jpg");
        Assertions.assertThat(img2.getDescricao()).isEqualTo("Um Leão dahora");

    }
}
