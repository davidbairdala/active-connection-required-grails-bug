<html>
  <body>
    <h1>"Active Connection is required" Sample</h1>
    <ul>
      <li><a href="${createLink(action:'willFail1')}">Will fail with exception because logMessage is transactional</a></li>
      <li><a href="${createLink(action:'willFail2')}">Will fail even if logMessage uses database</a></li>
      <li><a href="${createLink(action:'willSucceed1')}">Will succeed because logMessage is not transactional</a></li>
      <li><a href="${createLink(action:'willSucceed2')}">Will succeed because not using withNewSession</a></li>
      <li><a href="${createLink(action:'willSucceed3')}">Will succeed because call to logMessage is omitted</a></li>
    </ul>

    <div>
      <g:if test="${person}">
        Person Added: ${person.firstName} ${person.surname} ${person.createdOn.format("yyyy-MM-dd HH:mm:ss.SSS")}
      </g:if>
    </div>

  </body>
</html>