package OperateurDeTransportObjet;

/**
 * Interface definition : GestionUtilisateurs
 * 
 * @author OpenORB Compiler
 */
public class _GestionUtilisateursStub extends org.omg.CORBA.portable.ObjectImpl
        implements GestionUtilisateurs
{
    static final String[] _ids_list =
    {
        "IDL:OperateurDeTransportObjet/GestionUtilisateurs:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = OperateurDeTransportObjet.GestionUtilisateursOperations.class;

    /**
     * Operation demandeAdhesion
     */
    public OperateurDeTransportObjet.GestionUtilisateursPackage.Adhesion demandeAdhesion(OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesion demandeAdhesion)
        throws OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentExistantException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("demandeAdhesion",true);
                    OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesionHelper.write(_output,demandeAdhesion);
                    _input = this._invoke(_output);
                    OperateurDeTransportObjet.GestionUtilisateursPackage.Adhesion _arg_ret = OperateurDeTransportObjet.GestionUtilisateursPackage.AdhesionHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentExistantExceptionHelper.id()))
                    {
                        throw OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentExistantExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("demandeAdhesion",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.GestionUtilisateursOperations _self = (OperateurDeTransportObjet.GestionUtilisateursOperations) _so.servant;
                try
                {
                    return _self.demandeAdhesion( demandeAdhesion);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation demandeInscriptionTrans
     */
    public OperateurDeTransportObjet.GestionUtilisateursPackage.InscriptionTrans demandeInscriptionTrans(OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeInscriptionTrans demandeInscriptionTrans)
        throws OperateurDeTransportObjet.GestionUtilisateursPackage.TransExistantException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("demandeInscriptionTrans",true);
                    OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeInscriptionTransHelper.write(_output,demandeInscriptionTrans);
                    _input = this._invoke(_output);
                    OperateurDeTransportObjet.GestionUtilisateursPackage.InscriptionTrans _arg_ret = OperateurDeTransportObjet.GestionUtilisateursPackage.InscriptionTransHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(OperateurDeTransportObjet.GestionUtilisateursPackage.TransExistantExceptionHelper.id()))
                    {
                        throw OperateurDeTransportObjet.GestionUtilisateursPackage.TransExistantExceptionHelper.read(_exception.getInputStream());
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
                OperateurDeTransportObjet.GestionUtilisateursOperations _self = (OperateurDeTransportObjet.GestionUtilisateursOperations) _so.servant;
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
     * Operation verifierAdherent
     */
    public boolean verifierAdherent(int numeroAdherent, String motDePasse)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierAdherent",true);
                    _output.write_long(numeroAdherent);
                    _output.write_string(motDePasse);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierAdherent",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.GestionUtilisateursOperations _self = (OperateurDeTransportObjet.GestionUtilisateursOperations) _so.servant;
                try
                {
                    return _self.verifierAdherent( numeroAdherent,  motDePasse);
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
    public boolean verifierTransporteur(short codeVerif)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierTransporteur",true);
                    _output.write_short(codeVerif);
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
                OperateurDeTransportObjet.GestionUtilisateursOperations _self = (OperateurDeTransportObjet.GestionUtilisateursOperations) _so.servant;
                try
                {
                    return _self.verifierTransporteur( codeVerif);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getNumAdherent
     */
    public int getNumAdherent(String nomAdherent, String prenomAdherent)
        throws OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getNumAdherent",true);
                    _output.write_string(nomAdherent);
                    _output.write_string(prenomAdherent);
                    _input = this._invoke(_output);
                    int _arg_ret = _input.read_long();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantExceptionHelper.id()))
                    {
                        throw OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getNumAdherent",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.GestionUtilisateursOperations _self = (OperateurDeTransportObjet.GestionUtilisateursOperations) _so.servant;
                try
                {
                    return _self.getNumAdherent( nomAdherent,  prenomAdherent);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getZoneAdherent
     */
    public int getZoneAdherent(String nomAdherent, String prenomAdherent)
        throws OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getZoneAdherent",true);
                    _output.write_string(nomAdherent);
                    _output.write_string(prenomAdherent);
                    _input = this._invoke(_output);
                    int _arg_ret = _input.read_long();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantExceptionHelper.id()))
                    {
                        throw OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantExceptionHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getZoneAdherent",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.GestionUtilisateursOperations _self = (OperateurDeTransportObjet.GestionUtilisateursOperations) _so.servant;
                try
                {
                    return _self.getZoneAdherent( nomAdherent,  prenomAdherent);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
