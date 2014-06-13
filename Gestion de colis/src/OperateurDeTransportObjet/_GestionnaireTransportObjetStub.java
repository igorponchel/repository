package OperateurDeTransportObjet;

/**
 * Interface definition : GestionnaireTransportObjet
 * 
 * @author OpenORB Compiler
 */
public class _GestionnaireTransportObjetStub extends org.omg.CORBA.portable.ObjectImpl
        implements GestionnaireTransportObjet
{
    static final String[] _ids_list =
    {
        "IDL:OperateurDeTransportObjet/GestionnaireTransportObjet:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = OperateurDeTransportObjet.GestionnaireTransportObjetOperations.class;

    /**
     * Operation demandeInscriptionTrans
     */
    public OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTrans demandeInscriptionTrans(OperateurDeTransportObjet.GestionnaireTransportObjetPackage.DemandeInscriptionTrans demandeInscriptionTrans)
        throws OperateurDeTransportObjet.GestionnaireTransportObjetPackage.TransExistantException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("demandeInscriptionTrans",true);
                    OperateurDeTransportObjet.GestionnaireTransportObjetPackage.DemandeInscriptionTransHelper.write(_output,demandeInscriptionTrans);
                    _input = this._invoke(_output);
                    OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTrans _arg_ret = OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTransHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(OperateurDeTransportObjet.GestionnaireTransportObjetPackage.TransExistantExceptionHelper.id()))
                    {
                        throw OperateurDeTransportObjet.GestionnaireTransportObjetPackage.TransExistantExceptionHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("demandeInscriptionTrans",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.GestionnaireTransportObjetOperations _self = (OperateurDeTransportObjet.GestionnaireTransportObjetOperations) _so.servant;
                try
                {
                    return _self.demandeInscriptionTrans( demandeInscriptionTrans);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation notifierOffreTransport
     */
    public String notifierOffreTransport(String nomStationDepart, String nomStationArrivee)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("notifierOffreTransport",true);
                    _output.write_string(nomStationDepart);
                    _output.write_string(nomStationArrivee);
                    _input = this._invoke(_output);
                    String _arg_ret = _input.read_string();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("notifierOffreTransport",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.GestionnaireTransportObjetOperations _self = (OperateurDeTransportObjet.GestionnaireTransportObjetOperations) _so.servant;
                try
                {
                    return _self.notifierOffreTransport( nomStationDepart,  nomStationArrivee);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation notifierOffreAcceptee
     */
    public String notifierOffreAcceptee(int numeroTransporteur, String numeroOffre)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("notifierOffreAcceptee",true);
                    _output.write_long(numeroTransporteur);
                    _output.write_string(numeroOffre);
                    _input = this._invoke(_output);
                    String _arg_ret = _input.read_string();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("notifierOffreAcceptee",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.GestionnaireTransportObjetOperations _self = (OperateurDeTransportObjet.GestionnaireTransportObjetOperations) _so.servant;
                try
                {
                    return _self.notifierOffreAcceptee( numeroTransporteur,  numeroOffre);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation verifierTransporteur
     */
    public boolean verifierTransporteur(int numeroTransporteur, String codeTransport)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierTransporteur",true);
                    _output.write_long(numeroTransporteur);
                    _output.write_string(codeTransport);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierTransporteur",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.GestionnaireTransportObjetOperations _self = (OperateurDeTransportObjet.GestionnaireTransportObjetOperations) _so.servant;
                try
                {
                    return _self.verifierTransporteur( numeroTransporteur,  codeTransport);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation enregistrerObjet
     */
    public void enregistrerObjet(OperateurDeTransportObjet.Objet objet)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregistrerObjet",false);
                    OperateurDeTransportObjet.ObjetHelper.write(_output,objet);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregistrerObjet",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.GestionnaireTransportObjetOperations _self = (OperateurDeTransportObjet.GestionnaireTransportObjetOperations) _so.servant;
                try
                {
                    _self.enregistrerObjet( objet);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation notifierEtatObjet
     */
    public void notifierEtatObjet(String idObjet, OperateurDeTransportObjet.EtatObjet etatObjet)
        throws OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("notifierEtatObjet",true);
                    _output.write_string(idObjet);
                    OperateurDeTransportObjet.EtatObjetHelper.write(_output,etatObjet);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantExceptionHelper.id()))
                    {
                        throw OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantExceptionHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("notifierEtatObjet",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.GestionnaireTransportObjetOperations _self = (OperateurDeTransportObjet.GestionnaireTransportObjetOperations) _so.servant;
                try
                {
                    _self.notifierEtatObjet( idObjet,  etatObjet);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation consulterEtatObjet
     */
    public OperateurDeTransportObjet.InfoObjet[] consulterEtatObjet(int numeroAdherent)
        throws OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("consulterEtatObjet",true);
                    _output.write_long(numeroAdherent);
                    _input = this._invoke(_output);
                    OperateurDeTransportObjet.InfoObjet[] _arg_ret = OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ListeInfoObjetHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantExceptionHelper.id()))
                    {
                        throw OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantExceptionHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("consulterEtatObjet",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.GestionnaireTransportObjetOperations _self = (OperateurDeTransportObjet.GestionnaireTransportObjetOperations) _so.servant;
                try
                {
                    return _self.consulterEtatObjet( numeroAdherent);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation notifierConnexion
     */
    public void notifierConnexion(int numeroTransporteur, OperateurDeTransportObjet.Transporteur transporteur)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("notifierConnexion",false);
                    _output.write_long(numeroTransporteur);
                    OperateurDeTransportObjet.TransporteurHelper.write(_output,transporteur);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("notifierConnexion",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.GestionnaireTransportObjetOperations _self = (OperateurDeTransportObjet.GestionnaireTransportObjetOperations) _so.servant;
                try
                {
                    _self.notifierConnexion( numeroTransporteur,  transporteur);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation notifierDeconnexion
     */
    public void notifierDeconnexion(int numeroTransporteur)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("notifierDeconnexion",false);
                    _output.write_long(numeroTransporteur);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("notifierDeconnexion",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.GestionnaireTransportObjetOperations _self = (OperateurDeTransportObjet.GestionnaireTransportObjetOperations) _so.servant;
                try
                {
                    _self.notifierDeconnexion( numeroTransporteur);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
