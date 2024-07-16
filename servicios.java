import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    public Topico crearTopico(Topico topico) {
        return topicoRepository.save(topico);
    }

    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    public Topico obtenerTopico(Long id) {
        return topicoRepository.findById(id).orElse(null);
    }

    public Topico actualizarTopico(Long id, Topico topicoActualizado) {
        Topico topico = obtenerTopico(id);
        if (topico != null) {
            topico.setTitulo(topicoActualizado.getTitulo());
            topico.setMensaje(topicoActualizado.getMensaje());
            return topicoRepository.save(topico);
        }
        return null;
    }

    public void eliminarTopico(Long id) {
        topicoRepository.deleteById(id);
    }
}

