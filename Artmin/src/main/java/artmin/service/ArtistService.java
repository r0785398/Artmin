package artmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import artmin.dao.ArtistDao;
import artmin.model.Artist;
import artmin.model.Event;
import artmin.model.EventLocation;

@Service("artistService")
@Transactional
public class ArtistService {

    @Autowired
    private ArtistDao dao;

    @Autowired
    EventService eventService;
    
    @Autowired
    EventLocationService eventLocationService;

    // zoeken van gebruiker op basis van ID
    public Artist findById(Long id) {
        return dao.findById(id);
    }

    // Bewaren van gebruiker
    public void saveArtist(Artist artist) {
        dao.saveArtist(artist);
    }

    // bijwerken van bestaande gebruiker
    public void updateArtist(Artist artist) {
        Artist entity = dao.findById(artist.getId());
        if (entity != null) {
            entity.setName(artist.getName());
            entity.setDescription(artist.getDescription());
            entity.setLogoUrl(artist.getLogoUrl());
        }
    }

    // verwijderen van gebruiker
    public void deleteArtistById(Long id) {
        // Eerst alle onnderliggende events verwijderen.
        List<Event> lstEvent = eventService.findAllEvents(id);

        for (Event tmp : lstEvent) {
            // Loop alle events af om te verwijderen
            eventService.deleteEventById(tmp.getId());
        }

        // Alle afhankelijke locaties verwijderen
        List<EventLocation> evtLocation =  eventLocationService.findAllMyLocations(id);

        for (EventLocation tmp : evtLocation) {
            // Loop alle events af om te verwijderen
            eventLocationService.deleteEventLocationById(tmp.getId());
        }

        // Verwijder Artiest Data
        dao.deleteArtistById(id);
    }

    // zoeken van alle gebruikers
    public List<Artist> findAllArtists() {
        return dao.findAllArtists();
    }
}
