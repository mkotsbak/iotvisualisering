
import org.scalajs.dom
import dom.document
import dom.window
import org.denigma.threejs._

import scala.scalajs.js

object VisualiseringsApp extends App {

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }

  println("Hei verden!")
  appendPar(document.body, "Hello World")

  val scene = new Scene
  val camera = new PerspectiveCamera(75,
    window.innerWidth / window.innerHeight, 0.1, 1000)

  val renderer = new WebGLRenderer
  renderer.setSize(window.innerWidth, window.innerHeight)
  document.body.appendChild(renderer.domElement)

  val geometry = new BoxGeometry( 1, 1, 1 )

  val material = new MeshBasicMaterial(
    js.Dynamic.literal(color = 0x00ff00).asInstanceOf[MeshBasicMaterialParameters])
  val cube = new Mesh( geometry, material )
  scene.add( cube )

  camera.position.z = 5

  def animate(timestamp: Double): Unit = {
    window.requestAnimationFrame(animate)

    cube.rotation.x += 0.1
    cube.rotation.y += 0.1

    renderer.render(scene, camera)
  }

  animate(0)
}
