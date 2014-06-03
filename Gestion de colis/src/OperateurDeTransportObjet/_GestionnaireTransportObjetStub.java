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
     * Operation notifierOffreTransport
     */
    public void notifierOffreTransport(int numeroStation)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("notifierOffreTransport",false);
                    _output.write_long(numeroStation);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("notifierOffreTransport",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.GestionnaireTransportObjetOperations _self = (OperateurDeTransportObjet.GestionnaireTransportObjetOperations) _so.servant;
                try
                {
                    _self.notifierOffreTransport( numeroStation);
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
     * Operation notifierOffreAcceptee
     */
    public void notifierOffreAcceptee(int numeroTransporteur)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("notifierOffreAcceptee",false);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("notifierOffreAcceptee",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.GestionnaireTransportObjetOperations _self = (OperateurDeTransportObjet.GestionnaireTransportObjetOperations) _so.servant;
                try
                {
                    _self.notifierOffreAcceptee( numeroTransporteur);
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
     * Operation notifierEtatObjet
     */
    public void notifierEtatObjet(int numeroObjet, OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet etatObjet)
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
                    _output.write_long(numeroObjet);
                    OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjetHelper.write(_output,etatObjet);
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
                    _self.notifierEtatObjet( numeroObjet,  etatObjet);
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
    public OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet consulterEtatObjet(String numeroObjet)
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
                    _output.write_string(numeroObjet);
                    _input = this._invoke(_output);
                    OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet _arg_ret = OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjetHelper.read(_input);
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
                    return _self.consulterEtatObjet( numeroObjet);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
