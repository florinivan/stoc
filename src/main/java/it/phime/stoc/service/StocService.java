package it.phime.stoc.service;

import it.phime.stoc.jpa.entity.Stoc;
import it.phime.stoc.jpa.repository.StocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StocService {

    private final StocRepository stocRepository;

    @Autowired
    public StocService(StocRepository stocRepository) {
        this.stocRepository = stocRepository;
    }

    // Example method to get all stoc entries
    public List<Stoc> getAllStocEntries() {
        return stocRepository.findAll();
    }

    // Example method to save a new stoc entry
    public Stoc saveStocEntry(Stoc stocEntity) {
        // You can add business logic/validation here before saving
        return stocRepository.save(stocEntity);
    }

    // Example method to get stoc entry by IDM and PROD_ID
    public Stoc getStocEntryByIdAndProdId(Integer idm, String prodId) {
        // You can add additional logic or error handling here
        return stocRepository.findByIdAndProdId(idm, prodId).orElse(null);
    }

    public void updateStocValues(List<StocUpdateRequest> stocUpdateRequests) {
        for (StocUpdateRequest request : stocUpdateRequests) {
            Stoc stocEntity = stocRepository.findByIdAndProdId(request.idm(), request.prodId())
                    .orElseThrow(() -> new RuntimeException("Stoc entry not found"));

            stocEntity.setValinv(request.valinv());
            stocRepository.save(stocEntity);
        }
    }
}
