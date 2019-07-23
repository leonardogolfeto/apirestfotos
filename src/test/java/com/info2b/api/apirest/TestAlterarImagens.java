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
public class TestAlterarImagens {

    @Autowired
    private ImagensRepository repository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        List<Imagens> imgs = new ArrayList<>();
        imgs.add(new Imagens("Homem e Lobo", "https://www.tediado.com.br/wp-content/uploads/2018/06/fotos-legais-que-comprovam-que-angulo-certo-tudo-19.jpg", "Um homem e um lobo legal"));
        imgs.add(new Imagens("Leão", "https://abrilexame.files.wordpress.com/2017/12/sd_2712.jpg", "Um Leão dahora"));
        imgs.add(new Imagens("Galgo", "https://meusanimais.com.br/wp-content/uploads/2018/02/galgos.jpg", "Um Galgo"));
        imgs.add(new Imagens("Pastor Alemão", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Long-haired_German_shepherd_dog.jpg/1200px-Long-haired_German_shepherd_dog.jpg", "Pastor Alemão, O melhor dog que ja existiu"));
        imgs.add(new Imagens("Urso Panda", "https://www.drcurioso.com.br/media/image_bank/2017/8/urso-panda.jpg.750x0_q95_crop.jpg", "O Animal mais fofo"));
        this.repository.saveAll(imgs);
    }

    @Test
    public void testAlterarImagemById(){

        Imagens img = this.repository.findById((long)3);
        img.setTitulo("Galgo Legal");
        img.setDescricao("Corrida de Galgos");

        this.repository.save(img);

        Imagens img2 = this.repository.findById((long)3);

        Assertions.assertThat(img2.getTitulo()).isEqualTo("Galgo Legal");
        Assertions.assertThat(img2.getDescricao()).isEqualTo("Corrida de Galgos");

    }

}