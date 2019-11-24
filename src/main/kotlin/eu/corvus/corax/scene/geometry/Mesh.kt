package eu.corvus.corax.scene.geometry

import eu.corvus.corax.scene.geometry.buffers.BufferType
import eu.corvus.corax.scene.geometry.buffers.VertexArrayObject
import eu.corvus.corax.scene.geometry.buffers.VertexBufferObject
import org.lwjgl.opengl.GL30.*
import org.lwjgl.system.MemoryUtil

/**
 * @author Vlad Ravenholm on 11/24/2019
 *
 * @TODO set the Type { Static, Dynamic, Stream } based of scripts & other hints like controls
 * Should contain bound information
 *
 */
class Mesh(name: String = "Mesh"): Geometry(name) {

    var glObject: VertexArrayObject? = null
        private set

    fun createSimple(vertexArray: FloatArray, indices: IntArray, textCoord: FloatArray = FloatArray(2) { it.toFloat() }): Mesh {
        val vao = VertexArrayObject(glGenVertexArrays())
        vao.createBuffers {
            val buffer = MemoryUtil.memAllocFloat(vertexArray.size)
            buffer.put(vertexArray).flip()
            put(BufferType.Vertex, VertexBufferObject(glGenBuffers(), buffer, BufferType.Vertex))
        }
        glObject = vao

        return this
    }
}