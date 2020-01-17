package sk.tsystems.jobs.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import sk.tsystems.jobs.entity.Position;

@Component
@Transactional
public class PositionServiceJPA implements PositionService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addPosition(Position position) {
		entityManager.persist(position);

	}
	

	public int deleteAllFromTable() {
		return entityManager.createQuery("delete from Position").executeUpdate();

	}
	
	

	@Override
	public Position getPosition(int ident) {
		try {
			return (Position) entityManager.createQuery("select p from Position p where p.ident = :ident")
					.setParameter("ident", ident).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return null;
	}
	
	
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Position> getAllPositions() {
		return (List<Position>) entityManager.createQuery("select p from Position p order by p.publicationStartDate desc").setMaxResults(1).getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Position> getPositionList() {
		return (List<Position>) entityManager.createQuery("select p from Position p order by p.publicationStartDate desc").getResultList();
	
	}


	@Override
	public long getAllCountOffers() {
		
		return   (long) entityManager.createQuery("select count(p) from Position p").getSingleResult();
	}



}

