package OperateurDeTransportObjet;

/**
 * Interface definition : Transporteur
 * 
 * @author OpenORB Compiler
 */
public class _TransporteurStub extends org.omg.CORBA.portable.ObjectImpl
        implements Transporteur
{
    static final String[] _ids_list =
    {
        "IDL:OperateurDeTransportObjet/Transporteur:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = OperateurDeTransportObjet.TransporteurOperations.class;

    /**
     * Operation notifierOffreTransport
     */
    public void notifierOffreTransport(String nomStationDepart, String nomStationArrivee, String numeroOffre)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("notifierOffreTransport",false);
                    _output.write_string(nomStationDepart);
                    _output.write_string(nomStationArrivee);
                    _output.write_string(numeroOffre);
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
                OperateurDeTransportObjet.TransporteurOperations _self = (OperateurDeTransportObjet.TransporteurOperations) _so.servant;
                try
                {
                    _self.notifierOffreTransport( nomStationDepart,  nomStationArrivee,  numeroOffre);
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
     * Operation notifierOffrePriseEnCharge
     */
    public void notifierOffrePriseEnCharge(String numeroOffre)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("notifierOffrePriseEnCharge",false);
                    _output.write_string(numeroOffre);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("notifierOffrePriseEnCharge",_opsClass);
                if (_so == null)
                   continue;
                OperateurDeTransportObjet.TransporteurOperations _self = (OperateurDeTransportObjet.TransporteurOperations) _so.servant;
                try
                {
                    _self.notifierOffrePriseEnCharge( numeroOffre);
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
