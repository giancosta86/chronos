package info.gianlucacosta.chronos.ast

import info.gianlucacosta.chronos.ast.exceptions.{DuplicateEventException, DuplicateProcedureException}


case class Program(globalStatements: Block, events: Seq[Event], procedures: Seq[Procedure]) extends Node {
  private val eventsMap = {
    var result = Map.empty[String, Event]

    for (event <- events) {
      if (result.contains(event.name)) {
        throw new DuplicateEventException(event.name)
      }

      result += (event.name -> event)
    }

    result
  }


  private val proceduresMap = {
    var result = Map.empty[String, Procedure]

    for (procedure <- procedures) {
      if (result.contains(procedure.name)) {
        throw new DuplicateProcedureException(procedure.name)
      }

      result += (procedure.name -> procedure)
    }

    result
  }


  def startEvent: Option[Event] = getEvent("start")

  def getEvent(eventName: String): Option[Event] = eventsMap.get(eventName)

  def getProcedure(procedureName: String): Option[Procedure] = proceduresMap.get(procedureName)

  override def accept[T](visitor: AstVisitor[T]): T =
    visitor.visit(this)

}
