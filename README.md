# chat-storage-service

Chat Storage MicroService :

User session -> 1 st message (1 session, 1 msg)
             —> 2 nd message (No need for a new 2nd session, instead add message)

**HLD** :

User —> Chat —> Store Chat Session & Messages

**Database** :

chat_session :
session_id, sender_name, mail_id, is_favourite(default=false), delete (default=false) , created_timestamp, updated_timestamp

message:
message_id, message,  session_id, sender_name, delete (default=false)

**APIs** :

POST create sessions,
POST add messages,
GET retrieve messages,
UPDATE manage sessions (rename of session)

**LLD**:
Framework & Language : SpringBoot& Java
Database : MongoDB (scalability)
