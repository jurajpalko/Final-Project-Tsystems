package sk.tsystems.jobs.service;

import sk.tsystems.jobs.entity.Position;

public interface PositionService {

	void addPosition(Position position);
	
	Position getPosition(int ident);
}
