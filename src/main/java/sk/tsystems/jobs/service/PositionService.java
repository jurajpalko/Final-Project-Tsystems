package sk.tsystems.jobs.service;

import java.util.List;

import sk.tsystems.jobs.entity.Position;

public interface PositionService {

	void addPosition(Position position);
	
	Position getPosition(int ident);
	List<Position> getAllPositions();
}
