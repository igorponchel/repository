package impl;

import OperateurDeTransportObjet.Objet;
import OperateurDeTransportObjet.StationPOA;
import OperateurDeTransportObjet.StationPackage.AucunCasierDisponibleException;
import entites.ui.StationUI;
import exception.AucunCasierLibreException;

public class StationImpl extends StationPOA {

	private StationUI maStation;

	public StationImpl(StationUI station) {

		this.maStation = station;
	}

	@Override
	public int reserverCasier(int numeroAdherent)
			throws AucunCasierDisponibleException {

		int numeroCasier;
		try {
			numeroCasier = maStation.getNumeroCasierLibre();

			return numeroCasier;
			
		} catch (AucunCasierLibreException e) {
			// TODO Auto-generated catch block
			throw new AucunCasierDisponibleException("Aucun casier n'est disponible");
		}
	}

	@Override
	public void notifierInfoTransportObjet(String codeTransport, Objet objet) {

		maStation.ajouterCoupleCodeTransportCasier(codeTransport, objet.numeroCasierArrivee);
		maStation.ajouterCoupleNumCasierIdObjet(objet.numeroCasierArrivee, objet.idObjet);
		maStation.ajouterCoupleNumAdherentObjet(objet.numDestinataire, objet);
	}

	@Override
	public void notifierNumTransporteurObjet(int numTransporteur, String idObjet) {
		// TODO Auto-generated method stub
		maStation.ajouterCoupleNumTransporteurCasier(numTransporteur, idObjet);
	}

}
