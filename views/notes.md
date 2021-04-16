notes.md

<pre>
		nanti dipelajari maksud dari kondisi ini apa ?
		- if params[:view].try(:eql?, 'structure')
    
		    #organizational-container data-source=officers_datasource_profile_positions_path

	    - else
		    = render 'components/jd_list/main', collection: @collection, components: [:search,:sort,:import, :export, :structure] , resource_base_path: 'officer'	
	</pre>
	  